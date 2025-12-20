package hr.codenamecode.codedms.http.calls;

import hr.codenamecode.codedms.data.objects.ContentStream;
import hr.codenamecode.codedms.exceptions.CmisRuntimeException;
import hr.codenamecode.codedms.http.Call;
import hr.codenamecode.codedms.http.CmisSelector;
import hr.codenamecode.codedms.service.ObjectService;
import hr.codenamecode.codedms.utils.HttpUtils;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Predicate;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static jakarta.servlet.http.HttpServletResponse.SC_PARTIAL_CONTENT;

@CmisSelector("content")
public class GetContent extends Call {

    @Inject
    private ObjectService objectService;

    @Override
    public void serve(HttpServletRequest req, HttpServletResponse resp) {
        String repositoryId = HttpUtils.getRepositoryId(req);
        String objectId = HttpUtils.getStringParameter(req, "objectId", Objects::nonNull);
        String streamId = HttpUtils.getStringParameter(req, "streamId");
        BigInteger offset = HttpUtils.getBigIntegerParameter(req, "offset");
        BigInteger length = HttpUtils.getBigIntegerParameter(req, "length");
        String contentDisposition = HttpUtils.getStringParameter(req, "contentDisposition",
                (Predicate<String>) cd -> cd.equalsIgnoreCase("attachment") || cd.equalsIgnoreCase("inline"));

        ContentStream content = objectService.getContentStream(repositoryId, objectId, streamId, offset, length, null);

        if (content == null || content.getStream() == null) {
            throw new CmisRuntimeException("content stream is null");
        }

        String contentType = content.getMimetype() == null ? null : content.getMimetype();

        if ((offset == null || offset.signum() == 0) && length == null) {
            resp.setStatus(SC_OK);
        } else {
            resp.setStatus(SC_PARTIAL_CONTENT);

            if (content.getLength() != null && content.getLength().signum() == 1) {
                BigInteger firstBytePos = (offset == null ? BigInteger.ZERO : offset);
                BigInteger lastBytePos = firstBytePos.add(content.getLength().subtract(BigInteger.ONE));

                resp.setHeader("Content-Range", "bytes " + firstBytePos + "-" + lastBytePos + "/*");
            }
        }
        String contentFilename = content.getFilename() == null ? "content" : content.getFilename();

        resp.setContentType(contentType);
        resp.setHeader(
                "Content-Disposition",
                HttpUtils.encodeContentDisposition(contentDisposition, contentFilename));

        InputStream in = content.getStream();
        try {
            in.transferTo(resp.getOutputStream());
        } catch (IOException e) {
            throw new CmisRuntimeException("failed to write content stream", e);
        }
    }
}

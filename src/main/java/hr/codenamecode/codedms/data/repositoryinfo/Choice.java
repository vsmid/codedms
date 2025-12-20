package hr.codenamecode.codedms.data.repositoryinfo;

import lombok.Data;

import java.util.List;

@Data
public class Choice<T> {
    private String displayName;
    private List<T> value;
    private List<Choice<T>> choice;
}
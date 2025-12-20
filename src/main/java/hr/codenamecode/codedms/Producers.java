package hr.codenamecode.codedms;

import hr.codenamecode.codedms.http.json.adapters.*;
import hr.codenamecode.codedms.mapper.ObjectDataMapper;
import hr.codenamecode.codedms.utils.TypeCache;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.cdi.SessionFactoryProvider;

import javax.sql.DataSource;

public class Producers {

    @Resource(lookup = "jdbc/ds")
    private DataSource dataSource;

    @Produces
    @Singleton
    public Jsonb jsonb() {
        JsonbConfig jsonbConfig = new JsonbConfig();
        jsonbConfig.withNullValues(true);
        jsonbConfig.withAdapters(new BaseTypeIdAdapter(), new CmisVersionAdapter(), new PropertyTypeAdapter(),
                new AclPropagationAdapter(), new SupportedPermissionsAdapter(), new CapabilityAclAdapter(),
                new CapabilityContentStreamUpdatabilityAdapter(), new CapabilityChangesAdapter(),
                new CapabilityOrderByAdapter(), new CapabilityJoinAdapter(), new CapabilityQueryAdapter(),
                new CapabilityRenditionsAdapter(), new CardinalityAdapter(), new UpdatabilityAdapter(),
                new ContentStreamAllowedAdapter());
        return JsonbBuilder.newBuilder().withConfig(jsonbConfig).build();
    }

    @Produces
    @Named("typeCache")
    @Singleton
    public TypeCache typeCache() {
        return new TypeCache();
    }

    @Produces
    @ApplicationScoped
    @SessionFactoryProvider
    public SqlSessionFactory produceFactory() {
        Environment defaultEnv = new Environment("default", new ManagedTransactionFactory(), dataSource);

        Configuration configuration = new Configuration();
        configuration.addMapper(ObjectDataMapper.class);
        configuration.setEnvironment(defaultEnv);

        return new SqlSessionFactoryBuilder().build(configuration);
    }
}

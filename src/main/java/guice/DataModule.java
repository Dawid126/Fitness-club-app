package guice;

import com.google.inject.AbstractModule;
import persistence.DataManager;
import persistence.HibernateManager;
import persistence.IDataManager;

public class DataModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(IDataManager.class).to(HibernateManager.class);
    }
}

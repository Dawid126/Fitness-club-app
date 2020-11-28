package guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import persistance.DataManager;
import persistance.IDataManager;

public class DataModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(IDataManager.class).to(DataManager.class);
    }
}

package register;

import java.io.IOException;
import java.sql.SQLException;

public interface RegisterLoader {

	void save(Register register)  ;

	Register load() ;

}
## Bcors Library

### Download

You can download the latest version of Bcors for Java from the link below:

[Download Bcors Java Library](https://github.com/ByteBigBoss/Bcors/releases/download/Java/Bcors.jar)


### Usage
1. Add Bcors.jar file to your project library
2. call Bcors.setCors() static method and pass HttpServletRequest HttpServletResponse to it
3. call same method in doOptions() method to preflight request, check requesting domain is allowed to access POST or GET method else Block it.

### Sample Usage
```
import com.bytebigboss.bcors.Bcors; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ByteBigBoss
 */
@WebServlet(name = "SystemStatus", urlPatterns = {"/SystemStatus"})
public class SystemStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Bcors.setCors(req, res); //2.

    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Bcors.setCors(req, res);
        res.setStatus(HttpServletResponse.SC_OK);

    }

}
```

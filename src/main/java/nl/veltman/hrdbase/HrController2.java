package nl.veltman.hrdbase;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class HrController2 {

    @CrossOrigin(origins="http://localhost")
    @GetMapping("departments")
    public ArrayList<Department> getDepartments() throws SQLException {
        return DatabaseManager.getDepartments();
    }
}

package ojt.readexceldemo.system.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ojt.readexceldemo.system.ExcelReader;

@Controller
public class MainController {
    @Autowired
    ExcelReader er;

    @RequestMapping(value = "/read-excel")
    public ModelAndView goToExcelPage() throws IOException {
        List<List<Object>> rows = er.readExcel();
        ModelAndView model = new ModelAndView("read-excel");
        model.addObject("rows", rows);
        return model;
    }
}

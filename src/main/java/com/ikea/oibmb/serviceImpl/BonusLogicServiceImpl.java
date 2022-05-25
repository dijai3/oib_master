package com.ikea.oibmb.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ikea.oibmb.pojo.CapingHrs;
import com.ikea.oibmb.pojo.ForeCastData;
import com.ikea.oibmb.pojo.Payroll;
import com.ikea.oibmb.pojo.Person;
import com.ikea.oibmb.service.BonusGoalDataService;
import com.ikea.oibmb.service.BonusLogicService;
import com.ikea.oibmb.service.ForecastDataService;
import com.ikea.oibmb.service.PAOMService;
import com.ikea.oibmb.service.PayrollService;

@Service
public class BonusLogicServiceImpl implements BonusLogicService {

    @Value("${spring.cloud.gcp.project-id}")
    private String projectId;

    @Autowired
    private PayrollService payrollService;

    @Autowired
    private PAOMService paomService;

    @Autowired
    private ForecastDataService forecastDataService;

    @Autowired
    private BonusGoalDataService bonusGoalDataService;


    @Override
    public List<Payroll> readDataFromBigquery() {
        List<Payroll> payrollList = payrollService.getPayrollData();
        List<Person> personList = paomService.getPAOMData();
        List<ForeCastData> foreCastList = forecastDataService.getForeCastData();
        List<CapingHrs> capingHrsList = bonusGoalDataService.getCapingHrsList();

        return null;
    }



}

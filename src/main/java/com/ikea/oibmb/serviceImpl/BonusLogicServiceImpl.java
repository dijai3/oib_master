package com.ikea.oibmb.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.util.DateTime;
import com.ikea.oibmb.pojo.CapingHrs;
import com.ikea.oibmb.pojo.ForeCastData;
import com.ikea.oibmb.pojo.Payroll;
import com.ikea.oibmb.pojo.Person;
import com.ikea.oibmb.service.BonusGoalDataService;
import com.ikea.oibmb.service.BonusLogicService;
import com.ikea.oibmb.service.ForecastDataService;
import com.ikea.oibmb.service.PAOMService;
import com.ikea.oibmb.service.PayrollService;
import com.ikea.oibmb.utils.DateUtility;

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
        // List<Payroll> payrollList = payrollService.getPayrollData();
        List<Person> personList = applyEligibilityCriteria(paomService.getPAOMData());
        // List<ForeCastData> foreCastList = forecastDataService.getForeCastData();
        // List<CapingHrs> capingHrsList = bonusGoalDataService.getCapingHrsList();

        return null;
    }

    private List<Person> applyEligibilityCriteria(List<Person> personList) {
        List<Person> filteredList = new ArrayList<>();
        personList.forEach(person -> {
            if (checkJoiningDate(person) &&
                    checkTerminationDate(person)) {
                filteredList.add(person);
            }
        });
        return filteredList;
    }

    private boolean checkJoiningDate(Person person) {
        Date joiningDate = new Date(person.getJoiningDate().getValue());// 2021-05-07
        Date joiningEligibilityDate = new Date(DateUtility.getJoiningEligibilityDate().getValue());// 2021-03-05"
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        if (fmt.format(joiningDate).compareTo(fmt.format(joiningEligibilityDate)) >= 0)
            return true;
        return false;
    }

    private boolean checkTerminationDate(Person person) {
        Date terminationDate = new Date(person.getLeavingDate().getValue());// 2021-05-07
        Date terminationEligibilityDate = new Date(DateUtility.getTerminateEligibilityDate().getValue());
        Date InfiniteDate = new Date(DateUtility.getInfiniteDate().getValue());
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        if (fmt.format(terminationDate).equals(fmt.format(terminationEligibilityDate)) ||
                fmt.format(terminationDate).equals(fmt.format(InfiniteDate)))
            return true;
        if (!person.getTackStatus().equalsIgnoreCase("BZ"))
            return true;
        return false;
    }
}

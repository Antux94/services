package com.bbva.ccol.riskadmissionscalculateincomes;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.RequestTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.ResponseTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.*;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyMock {
    public Calculate getCalculate(){
        Calculate response = new Calculate();
        Person person = new Person();
        IdentityDocument identityDocument = new IdentityDocument();
        IdentityDocumentTypeEnum identityDocumentTypeEnum = IdentityDocumentTypeEnum.valueOf("CC");
        identityDocument.setDocumentType(identityDocumentTypeEnum);
        identityDocument.setDocumentNumber("23124451612");
        person.setIdentityDocument(identityDocument);
        person.setFirstName("person First Name");
        person.setMiddleName("person middleName");
        person.setLastName("person Lastname");
        response.setPerson(person);

        List<InformationSources> informationSourcesList = new ArrayList<>();
        InformationSources informationSources = new InformationSources();
        InformationSourcesIdEnum id = InformationSourcesIdEnum.valueOf("INCOME_PREDICTOR");
        informationSources.setId(id);
        informationSourcesList.add(informationSources);
        response.setInformationSources(informationSourcesList);

        Product product = new Product();
        product.setId("456");
        product.setName("Name Product");
        response.setProduct(product);

        return response;
    }

    public Calculate getCalculate1(){
        Calculate response = new Calculate();
        Person person = new Person();
        IdentityDocument identityDocument = new IdentityDocument();
        IdentityDocumentTypeEnum identityDocumentTypeEnum = IdentityDocumentTypeEnum.valueOf("PASSPORT");
        identityDocument.setDocumentType(identityDocumentTypeEnum);
        identityDocument.setDocumentNumber("23124451612");
        person.setIdentityDocument(identityDocument);
        person.setFirstName("person First Name");
        person.setMiddleName("person middleName");
        person.setLastName("person Lastname");
        person.setLaboralInformation(new LaboralInformation());
        person.getLaboralInformation().setCompanyId("901053862-8");
        person.getLaboralInformation().setDeclaratedIncome(1000L);


        response.setPerson(person);

        List<InformationSources> informationSourcesList = new ArrayList<>();
        InformationSources informationSources = new InformationSources();
        InformationSourcesIdEnum id = InformationSourcesIdEnum.valueOf("INCOME_PREDICTOR");
        informationSources.setId(id);
        informationSourcesList.add(informationSources);
        response.setInformationSources(informationSourcesList);

        Product product = new Product();
        product.setId("456");
        product.setName("Name Product");
        response.setProduct(product);

        return response;
    }

    public BCalculate getBCalculateIn(){
        BCalculate responseB = new BCalculate();
        BPerson person = new BPerson();
        BIdentityDocument identityDocument = new BIdentityDocument();
        BIdentityDocumentTypeEnum identityDocumentTypeEnum = BIdentityDocumentTypeEnum.valueOf("PASSPORT");
        identityDocument.setDocumentType(identityDocumentTypeEnum);
        identityDocument.setDocumentNumber("1234");
        person.setIdentityDocument(identityDocument);
        person.setFirstName("Bperson First Name");
        person.setMiddleName("Bperson middleName");
        person.setLastName("Bperson Lastname");

        person.setLaboralInformation(new BLaboralInformation());
        person.getLaboralInformation().setCompanyId("901053862-8");
        person.getLaboralInformation().setDeclaratedIncome(1000L);

        responseB.setPerson(person);

        List<BInformationSources> informationSourcesListB = new ArrayList<>();
        BInformationSources informationSources = new BInformationSources();
        BInformationSourcesIdEnum id = BInformationSourcesIdEnum.valueOf("QUANTUM");
        informationSources.setId(id);
        informationSources.setIsConsulted(true);
        informationSourcesListB.add(informationSources);
        responseB.setInformationSources(informationSourcesListB);

        BProduct product = new BProduct();
        product.setId("456");
        product.setName("Name Product");
        responseB.setProduct(product);

        return responseB;
    }

    public Data getData(Calculate calculate){
        Data response = new Data();

        Person person = new Person();
        IdentityDocument identityDocument = new IdentityDocument();
        IdentityDocumentTypeEnum documentType = IdentityDocumentTypeEnum.valueOf("CC");
        identityDocument.setDocumentType(documentType);
        identityDocument.setDocumentNumber("123456");
        person.setIdentityDocument(identityDocument);
        person.setFirstName("Maria");
        person.setMiddleName("prueba");
        person.setLastName("Perez");

        person.setLaboralInformation(new LaboralInformation());
        person.getLaboralInformation().setCompanyId("901053862-8");
        person.getLaboralInformation().setDeclaratedIncome(1000L);

        response.setPerson(person);

        List<InformationSources> informationSources = new ArrayList<>();
        for(InformationSources data : calculate.getInformationSources()){
            data.setIsConsulted(true);
            informationSources.add(data);
        }
        response.setInformationSources(informationSources);

        TotalIncomes totalIncomes = new TotalIncomes();
        totalIncomes.setAmount(1234567L);
        totalIncomes.setCurrency("currencyIncomes");
        response.setTotalIncomes(totalIncomes);

        TotalDeductions totalDeductions = new TotalDeductions();
        totalDeductions.setAmount(1234L);
        totalDeductions.setCurrency("CurrencyDeductions");
        response.setTotalDeductions(totalDeductions);

        List<Employers> employersList = new ArrayList<>();
        Employers employers = new Employers();
        EmployerInfo employerInfo = new EmployerInfo();
        employerInfo.setCompanyName("CompanyName");
        IdentityDocument identityDocument1 = new IdentityDocument();
        IdentityDocumentTypeEnum identityDocumentTypeEnum = IdentityDocumentTypeEnum.valueOf("PASSPORT");
        identityDocument1.setDocumentType(identityDocumentTypeEnum);
        identityDocument1.setDocumentNumber("34235345345");
        employerInfo.setIdentityDocument(identityDocument1);
        EconomicActivity economicActivity = new EconomicActivity();
        economicActivity.setId("34234129");
        economicActivity.setName("economicActivityname");
        economicActivity.setInternationalClassification("economicInternationalClassification");
        employerInfo.setEconomicActivity(economicActivity);
        employers.setEmployerInfo(employerInfo);


        ParticipantInformation participantInformation = new ParticipantInformation();
        Seniority seniority = new Seniority();
        seniority.setNumber(12313L);
        Period period = new Period();
        PeriodIdEnum periodIdEnum = PeriodIdEnum.valueOf("YEAR");
        period.setId(periodIdEnum);
        period.setName("namePeriod");
        seniority.setPeriod(period);
        participantInformation.setSeniority(seniority);


        List<Incomes> incomesList = new ArrayList<>();
        Incomes incomes = new Incomes();
        IncomesIdEnum incomesIdEnum = IncomesIdEnum.valueOf("SALARY");
        incomes.setId(incomesIdEnum);
        incomes.setName("bIncomesSET");
        IncomeAmount incomeAmount = new IncomeAmount();
        incomeAmount.setAmount(12312L);
        incomeAmount.setCurrency("incomeAmountCurrency");
        incomes.setIncomeAmount(incomeAmount);
        IncomesFrecuencyEnum incomesFrecuencyEnum = IncomesFrecuencyEnum.valueOf("DAILY");
        incomes.setFrecuency(incomesFrecuencyEnum);
        incomesList.add(incomes);
        participantInformation.setIncomes(incomesList);

        Deduction deduction = new Deduction();
        deduction.setAmount(468163L);
        deduction.setCurrency("deduction currency");
        participantInformation.setDeduction(deduction);

        EmploymentSituation employmentSituation = new EmploymentSituation();
        employmentSituation.setId("56457");
        employmentSituation.setName("employment Situation name");
        participantInformation.setEmploymentSituation(employmentSituation);

        participantInformation.setDateRelationship("11-07-2022");
        employers.setParticipantInformation(participantInformation);
        employersList.add(employers);
        response.setEmployers(employersList);

        EmploymentHistory employmentHistory = new EmploymentHistory();
        employmentHistory.setId(IdentifierTimeEnum.YEAR);
        employmentHistory.setTimeContinuity("6");
        employmentHistory.setDateContinuity("06-07-2017");
        response.setEmploymentHistory(employmentHistory);

        response.setStatus(new Status());
        response.getStatus().setId("SUCCESS");
        response.getStatus().setDescription("SUCCESS");

        return response;
    }

    public BData getBDataOut(BCalculate bCalculate) {
        BData response = new BData();

        BPerson bPerson = new BPerson();
        BIdentityDocument bIdentityDocument = new BIdentityDocument();
        BIdentityDocumentTypeEnum documentType = BIdentityDocumentTypeEnum.valueOf("CC");
        bIdentityDocument.setDocumentType(documentType);
        bIdentityDocument.setDocumentNumber("123456");
        bPerson.setIdentityDocument(bIdentityDocument);
        bPerson.setFirstName("Maria");
        bPerson.setMiddleName("prueba");
        bPerson.setLastName("Perez");

        bPerson.setLaboralInformation(new BLaboralInformation());
        bPerson.getLaboralInformation().setCompanyId("901053862-8");
        bPerson.getLaboralInformation().setDeclaratedIncome(1000L);

        response.setPerson(bPerson);

        response.setStatus(new BTstatus());
        response.getStatus().setId("SUCCESS");
        response.getStatus().setDescription("SUCCESS");


        List<BInformationSources> informationSources = new ArrayList<>();
        for(BInformationSources data : bCalculate.getInformationSources()){
            data.setIsConsulted(true);
            informationSources.add(data);
        }
        response.setInformationSources(informationSources);

        BTotalIncomes bTotalIncomes = new BTotalIncomes();
        bTotalIncomes.setAmount(1234567L);
        bTotalIncomes.setCurrency("currencyIncomes");
        response.setTotalIncomes(bTotalIncomes);

        BTotalDeductions bTotalDeductions = new BTotalDeductions();
        bTotalDeductions.setAmount(1234L);
        bTotalDeductions.setCurrency("CurrencyDeductions");
        response.setTotalDeductions(bTotalDeductions);

        List<BEmployers> bEmployersList = new ArrayList<>();
        BEmployers bEmployers = new BEmployers();
        BEmployerInfo bEmployerInfo = new BEmployerInfo();
        bEmployerInfo.setCompanyName("CompanyName");
        BIdentityDocument bIdentityDocument1 = new BIdentityDocument();
        BIdentityDocumentTypeEnum bIdentityDocumentTypeEnum = BIdentityDocumentTypeEnum.valueOf("PASSPORT");
        bIdentityDocument1.setDocumentType(bIdentityDocumentTypeEnum);
        bIdentityDocument1.setDocumentNumber("34235345345");
        bEmployerInfo.setIdentityDocument(bIdentityDocument1);
        BEconomicActivity bEconomicActivity = new BEconomicActivity();
        bEconomicActivity.setId("34234129");
        bEconomicActivity.setName("economicActivityname");
        bEconomicActivity.setInternationalClassification("EconomicInternationsClassificationB");
        bEmployerInfo.setEconomicActivity(bEconomicActivity);
        bEmployers.setEmployerInfo(bEmployerInfo);


        BParticipantInformation bParticipantInformation = new BParticipantInformation();
        BSeniority bSeniority = new BSeniority();
        bSeniority.setNumber(12313L);
        BPeriod bPeriod = new BPeriod();
        BPeriodIdEnum bPeriodIdEnum = BPeriodIdEnum.valueOf("YEAR");
        bPeriod.setId(bPeriodIdEnum);
        bPeriod.setName("namePeriod");
        bSeniority.setPeriod(bPeriod);
        bParticipantInformation.setSeniority(bSeniority);


        List<BIncomes> bIncomesList = new ArrayList<>();
        BIncomes bIncomes = new BIncomes();
        BIncomesIdEnum bIncomesIdEnum = BIncomesIdEnum.valueOf("SALARY");
        bIncomes.setId(bIncomesIdEnum);
        bIncomes.setName("bIncomesSET");
        BIncomeAmount bIncomeAmount = new BIncomeAmount();
        bIncomeAmount.setAmount(12312L);
        bIncomeAmount.setCurrency("incomeAmountCurrency");
        bIncomes.setIncomeAmount(bIncomeAmount);
        BIncomesFrecuencyEnum bIncomesFrecuencyEnum = BIncomesFrecuencyEnum.valueOf("DAILY");
        bIncomes.setFrecuency(bIncomesFrecuencyEnum);
        bIncomesList.add(bIncomes);
        bParticipantInformation.setIncomes(bIncomesList);

        BDeduction deduction = new BDeduction();
        deduction.setAmount(468163L);
        deduction.setCurrency("deduction currency");
        bParticipantInformation.setDeduction(deduction);

        BEmploymentSituation bEmploymentSituation = new BEmploymentSituation();
        bEmploymentSituation.setId("56457");
        bEmploymentSituation.setName("employment Situation name");
        bParticipantInformation.setEmploymentSituation(bEmploymentSituation);

        bParticipantInformation.setDateRelationship("11-07-2022");
        bEmployers.setParticipantInformation(bParticipantInformation);
        bEmployersList.add(bEmployers);
        response.setEmployers(bEmployersList);
        response.setAppId("appId");

        BEmploymentHistory bEmploymentHistory = new BEmploymentHistory();
        bEmploymentHistory.setId(BIdentifierTimeEnum.YEAR);
        bEmploymentHistory.setTimeContinuity("6");
        bEmploymentHistory.setDateContinuity("06-07-2017");
        response.setEmploymentHistory(bEmploymentHistory);

        return response;
    }

    public RequestTransactionCmlct001_1 getTransaccionCmlct001(){
        RequestTransactionCmlct001_1 response = new RequestTransactionCmlct001_1();

        response.setPerson(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.Person());
        response.getPerson().setIdentityDocument(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.IdentityDocument());
        response.getPerson().getIdentityDocument().setDocumentType("PASSPORT");
        response.getPerson().getIdentityDocument().setDocumentNumber("12434");
        response.getPerson().setFirstName("personPeticionTx");
        response.getPerson().setMiddleName("middleTx");
        response.getPerson().setLastName("lastnamePeticion");
        response.getPerson().setLaboralInformation(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.LaboralInformation());
        response.getPerson().getLaboralInformation().setCompanyId("901053862-8");
        response.getPerson().getLaboralInformation().setDeclaratedIncome(1000L);

        response.setInformationSources(new ArrayList<>());
        response.getInformationSources().add(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.InformationSources());
        response.getInformationSources().get(0).setId("APL");

        response.setProduct(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.Product());
        response.getProduct().setId("456");
        response.getProduct().setName("Name Product");

        return response;
    }

    public ResponseTransactionCmlct001_1 getRespuestaTransaccionCmlct001() {
        ResponseTransactionCmlct001_1 response = new ResponseTransactionCmlct001_1();
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.IdentityDocument identityDocument = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.IdentityDocument();
        identityDocument.setDocumentType(IdentityDocumentTypeEnum.ARC.getId());
        identityDocument.setDocumentNumber("4324234");

        response.setData(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Data());

        response.getData().setPerson(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Person());
        response.getData().getPerson().setIdentityDocument(identityDocument);
        response.getData().getPerson().setFirstName("fisrtName");
        response.getData().getPerson().setMiddleName("middlename");
        response.getData().getPerson().setLastName("TxLastNamePerson");

        response.getData().getPerson().setLaboralInformation(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.LaboralInformation());
        response.getData().getPerson().getLaboralInformation().setCompanyId("901053862-8");
        response.getData().getPerson().getLaboralInformation().setDeclaratedIncome(1000L);

        response.getData().setStatus(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Status());
        response.getData().getStatus().setId("SUCCESS");
        response.getData().getStatus().setDescription("SUCCESS");

        response.getData().setInformationSources(new ArrayList<>());

        response.getData().getInformationSources().add(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.InformationSources());
        response.getData().getInformationSources().get(0).setId("APL");
        response.getData().getInformationSources().get(0).setIsConsulted(true);


        response.getData().setTotalIncomes(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.TotalIncomes());
        response.getData().getTotalIncomes().setAmount(54L);
        response.getData().getTotalIncomes().setCurrency("currencyIncomesTx");

        response.getData().setTotalDeductions(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.TotalDeductions());
        response.getData().getTotalDeductions().setAmount(232L);
        response.getData().getTotalDeductions().setCurrency("currencyDeductionsTx");


        List<com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Employers> employersList = new ArrayList<>();
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Employers employers = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Employers();
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.EmployerInfo employersInfo = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.EmployerInfo();
        employersInfo.setCompanyName("TxCompanyName");
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.IdentityDocument identityDocument1 = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.IdentityDocument();
        identityDocument1.setDocumentType(IdentityDocumentTypeEnum.ARC.getId());
        identityDocument1.setDocumentNumber("4324234");
        employersInfo.setIdentityDocument(identityDocument1);
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.EconomicActivity economicActivity = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.EconomicActivity();
        economicActivity.setId("1233453");
        economicActivity.setName("nameActivitytx");
        economicActivity.setInternationalClassification("international");
        employersInfo.setEconomicActivity(economicActivity);
        employers.setEmployerInfo(employersInfo);


        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.ParticipantInformation participantInformation = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.ParticipantInformation();
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Seniority seniority = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Seniority();
        seniority.setNumber(123L);
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Period period = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Period();
        period.setId(PeriodIdEnum.DAY.getId());
        period.setName("nameperiodtx");
        seniority.setPeriod(period);
        participantInformation.setSeniority(seniority);

        List<com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Incomes> incomesList = new ArrayList<>();
        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Incomes incomes = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Incomes();
        incomes.setId(IncomesIdEnum.RENT.getId());
        incomes.setName("nameIncomesTx");
        incomes.setIncomeAmount(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.IncomeAmount());
        incomes.getIncomeAmount().setAmount(34525L);
        incomes.getIncomeAmount().setCurrency("currencyIncomeAmountTx");
        incomes.setFrecuency(IncomesFrecuencyEnum.BIWEEKLY.getId());
        incomesList.add(incomes);
        participantInformation.setIncomes(incomesList);

        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Deduction deduction = new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.Deduction();
        deduction.setAmount(34234L);
        deduction.setCurrency("currencyTx");
        participantInformation.setDeduction(deduction);

        com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.EmploymentSituation employmentSituation= new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.EmploymentSituation();
        employmentSituation.setId("12368");
        employmentSituation.setName("nameEmploymentSituationTx");
        participantInformation.setEmploymentSituation(employmentSituation);
        employers.setParticipantInformation(participantInformation);

        participantInformation.setDateRelationship("11-07-2022");
        employers.setParticipantInformation(participantInformation);
        employersList.add(employers);
        response.getData().setEmployers(employersList);
        response.setAppId("appid");

        response.getData().setEmploymentHistory(new com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.EmploymentHistory());
        response.getData().getEmploymentHistory().setId("YEAR");
        response.getData().getEmploymentHistory().setTimeContinuity("6");
        response.getData().getEmploymentHistory().setDateContinuity("01-06-2018");

        return response;
    }
}

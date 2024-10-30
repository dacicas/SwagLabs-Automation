package SwagLabsAutomation.utils;

public enum TestCases {
    T1("Testing the authentication"),
    T2("Testing the purchase of several items"),
    T3("testing end to end");
    private String testName;

    public String getTestName() {
        return testName;
    }

    TestCases(String value){
        this.testName = value;
    }
}

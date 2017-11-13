package ovning4;
//PROGRAMMET GÅR INTE ATT KOMPILERA, VARFÖR? Static refrence to a non-static field.
class Test {

    static int sv = 17;
    static int iv = 42;

    static int mA () {
        return iv;
    }

    static int mB () {
        return sv;
    }

    int mC () {
        return iv;
    }

    int mD() {
        return sv;
    }
}

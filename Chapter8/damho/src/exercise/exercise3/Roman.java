package Chapter8.damho.src.exercise.exercise3;

public enum Roman {
        M('M', 1000),
        D('D', 500),
        C('C', 100),
        L('L', 50),
        X('X', 10),
        V('V', 5),
        I('I', 1);

        private final char charValue;
        private final int intValue;

        Roman(char charValue, int intValue) {
            this.charValue = charValue;
            this.intValue = intValue;
        }

        public char getCharValue() {
            return charValue;
        }

        public int getIntValue() {
            return intValue;
        }
    }
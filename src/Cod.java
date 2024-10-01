public class Cod {

        private String inText;
        private String outText = "";
        private int key;

        Cod(String inText, int key) {
            this.inText = inText;
            this.key = key;
        }

        String coding() {
            outText = "";
            for (int i = 0; i < inText.length(); i++) {
                if ((int) inText.charAt(i) >= 1040 & (int) inText.charAt(i) <= 1071) {
                    outText += (char) (((int) inText.charAt(i) + key - 1040) % 32 + 1040);
                } else if ((int) inText.charAt(i) > 1071 & (int) inText.charAt(i) <= 1103) {
                    outText += (char) (((int) inText.charAt(i) + key - 1072) % 32 + 1072);
                } else if ((int) inText.charAt(i) == 32) {
                    outText += ' ';
                } else if ((int) inText.charAt(i) == (int) 'ё') {
                    outText += (char) (((int) 'е' + key - 1072) % 32 + 1072);
                } else if ((int) inText.charAt(i) == (int) 'Ё') {
                    outText += (char) (((int) 'Е' + key - 1040) % 32 + 1040);
                }
            }
            return outText;
        }

        String decoding() {
            for (int i = 0; i < inText.length(); i++) {
                if ((int) inText.charAt(i) >= 1040 & (int) inText.charAt(i) <= 1071) {
                    if ((int) inText.charAt(i) - key >= 1040)
                        outText += (char) ((int) inText.charAt(i) - key);
                    else {
                        outText += (char) (1072 - Math.abs((int) inText.charAt(i) - key - 1040));
                    }
                } else if ((int) inText.charAt(i) > 1071 & (int) inText.charAt(i) <= 1103) {
                    if ((int) inText.charAt(i) - key >= 1072)
                        outText += (char) ((int) inText.charAt(i) - key);
                    else {
                        outText += (char) (1104 - Math.abs((int) inText.charAt(i) - key - 1072));
                    }
                } else if ((int) inText.charAt(i) == 32) {
                    outText += ' ';
                }
            }
            return outText;

        }
    }


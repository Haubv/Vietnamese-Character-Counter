public class VietnameseCharacterCounter {
    public static int countVietnameseCharacters(String inputString) {
        String[] vietnameseCharacters = {"aw", "aa", "dd", "ee", "oo", "ow", "w"};
        int count = 0;

        for (int i = 0; i < inputString.length(); ) {
            if (i + 1 < inputString.length()) {
                String currentPair = inputString.substring(i, i + 2);
                if (contains(vietnameseCharacters, currentPair)) {
                    count++;
                    i += 2;  // Di chuyển 2 bước vì ta đã xử lý 1 cặp ký tự Tiếng Việt
                    continue;
                }
            }

            String singleCharacter = inputString.substring(i, i + 1);
            if (contains(vietnameseCharacters, singleCharacter)) {
                count++;
            }

            i += 1;  // Di chuyển 1 bước
        }

        return count;
    }

    public static boolean contains(String[] array, String targetValue) {
        for (String s : array) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String inputStr = "hfdawhwhcoomdd";
        int result = countVietnameseCharacters(inputStr);
        System.out.println("Input: " + inputStr);
        System.out.println("Output: " + result);
    }
}

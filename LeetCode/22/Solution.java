class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answers = new ArrayList();
        generate("", 0, 0, n, answers);
        System.out.println(answers);
        return answers;
    }
    public void generate(String curr, int currOpen, int currClosed, int n, List<String> answers) {
        if (currOpen == n && currClosed == n) {
            // arrived at a valid string
            answers.add(curr);
            return;
        }
        if (currClosed > currOpen || currOpen > n || currClosed > n) {
            // invalid cases
            return;
        }
        generate(curr + "(", currOpen + 1, currClosed, n, answers);
        generate(curr + ")", currOpen, currClosed + 1, n, answers);
    }
}

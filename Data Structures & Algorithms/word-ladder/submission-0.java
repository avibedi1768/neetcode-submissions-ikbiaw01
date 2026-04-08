class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));
        Set<String> hs = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();

        vis.add(beginWord);

        while (!q.isEmpty()) {
            Pair<String, Integer> curr = q.remove();

            if (curr.getKey().equals(endWord))
                return curr.getValue();

            String s = curr.getKey();
            int level = curr.getValue();

            for (int i = 0; i < s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != s.charAt(i)) {
                        String next = s.substring(0, i) + ch + s.substring(i + 1);

                        if (!vis.contains(next) && hs.contains(next)) {
                            vis.add(next);
                            q.add(new Pair<>(next, level + 1));
                        }
                    }
                }
            }
        }

        return 0;
    }
}

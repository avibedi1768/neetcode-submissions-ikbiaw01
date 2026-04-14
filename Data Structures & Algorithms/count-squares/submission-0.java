class CountSquares {
    Map<String, Integer> freq;

    public CountSquares() {
        freq = new HashMap<>();
    }
    
    public void add(int[] point) {
        String s = point[0] + " " + point[1];
        freq.put(s, freq.getOrDefault(s, 0) + 1);
    }
    
    public int count(int[] point) {
        int ans = 0;
        // String s = point[0] + " " + point[1];

        for (String p : freq.keySet()) {
            String arr[] = p.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);

            if (x != point[0] && y != point[1]) {
                String s1 = point[0] + " " + y, s2 = x + " " + point[1];

                if (freq.containsKey(s1) && freq.containsKey(s2)) {
                    ans += freq.get(p) * freq.get(s1) * freq.get(s2);
                }
            }
        }

        return ans;
    }
}

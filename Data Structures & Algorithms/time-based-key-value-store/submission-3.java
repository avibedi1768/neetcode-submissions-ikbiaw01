class TimeMap {
    Map<String, List<String[]>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key))
            hm.put(key, new ArrayList<>());

        hm.get(key).add(new String[] {value, timestamp + ""});

        // for (String k : hm.keySet()) {
        //     System.out.print(k + "->");

        //     for (String l[] : hm.get(k)) {
        //         System.out.print(Arrays.toString(l) + " ");
        //     }

        //     System.out.println();
        // }
    }

    public String get(String key, int timestamp) {
        if (!hm.containsKey(key))
            return "";

        List<String[]> al = hm.get(key);

        int beg = 0, end = al.size() - 1;
        String ans = "";

        while (beg <= end) {
            int mid = (beg + end) / 2;

            int curr = Integer.parseInt(al.get(mid)[1]);

            if (curr <= timestamp) {
                ans = al.get(mid)[0];
                beg = mid + 1;
            } else if (curr > timestamp) {
                end = mid - 1;
            }
        }

        return ans;
    }
}

/*
["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice",
"sad", 3], "get", ["alice", 3]]

*/
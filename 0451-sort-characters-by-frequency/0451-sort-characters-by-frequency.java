class Solution {
    public String frequencySort(String s) {

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList(map.keySet());
        // Sorts descending (highest values first)
        list.sort(Comparator.comparingInt(map::get).reversed());

        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
class Solution {
	public Map<String, List<String>> favoriteGenre (Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String,String> songsToGenreMap = new HashMap<>();
		for(String s: genreMap.keySet()){
            List<String> songsToGenre = genreMap.get(s);
            for(String i: songsToGenre){
                songsToGenreMap.put(i,s);
            }
        }
        HashMap<String,List<String>> userAllSongs = new HashMap<>();
        
        for(String s: userMap.keySet()){
            List<String> userSongs = userMap.get(s);
            HashMap<String,Integer> userFavGenres = new HashMap<>();
            for(String a: userSongs){
                userFavGenres.put(songsToGenreMap.get(a),
                                  userFavGenres.getOrDefault(songsToGenreMap.get(a),0)+1);
            }
            int max = Collections.max(userFavGenres.values());
            List<String> genre = new ArrayList<>();
            for(String b :userFavGenres.keySet()){
                if(userFavGenres.get(b)==max){
                    genre.add(b);
                }
            }
            userAllSongs.put(s,genre);
        }
        
        return userAllSongs;
        
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
		List<String> list2 = Arrays.asList("song5", "song6", "song7");
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();
		List<String> list3 = Arrays.asList("song1", "song3");
		List<String> list4 = Arrays.asList("song7");
		List<String> list5 = Arrays.asList("song2", "song4");
		List<String> list6 = Arrays.asList("song5", "song6");
		List<String> list7 = Arrays.asList("song8", "song9");
		genreMap.put("Rock", list3);
		genreMap.put("Dubstep", list4);
		genreMap.put("Techno", list5);
		genreMap.put("Pop", list6);
		genreMap.put("Jazz", list7);
        
        
        System.out.println(new Solution().favoriteGenre(userMap, genreMap));
    }
}

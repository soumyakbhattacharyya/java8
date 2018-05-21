package part2;

import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import part2.model.RollingStoneAlbum;
import part2.utility.CSVReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		List<RollingStoneAlbum> list = CSVReader.readCSV();
		
		
	
	}
	
	
	
	public static void predicateExample(List<RollingStoneAlbum> list) {
		Predicate<RollingStoneAlbum> isBefore1970 = (x) -> {return Year.of(Integer.parseInt(x.getYear())).isBefore(Year.of(1970));};
		Predicate<RollingStoneAlbum> isAfter1965 = (x) -> {return Year.of(Integer.parseInt(x.getYear())).isAfter(Year.of(1965));};
		printPerPredicateExample(list, isAfter1965.and(isBefore1970));
	}
	
	
	public static void printPerPredicateExample(List<RollingStoneAlbum> list, Predicate<RollingStoneAlbum> predicate) {
		for (RollingStoneAlbum album : list) {
			if (predicate.test(album)) {
				System.out.println(album);
			}
		}
	}
	
	public static void consumerExample(List<RollingStoneAlbum> list) {
		Consumer<RollingStoneAlbum> consumer = (x) -> {x.setArtist(x.getArtist().toUpperCase());};
		printPerConsumerExample(list, consumer);
	}
	
	public static void printPerConsumerExample(List<RollingStoneAlbum> list, Consumer<RollingStoneAlbum> consumer) {
		for (RollingStoneAlbum album : list) {
			consumer.accept(album);
			System.out.println(album.getArtist());
		}
	}
	
	public static void functionExample(List<RollingStoneAlbum> list) {
		Function<List<RollingStoneAlbum>, Map<String,Integer>> function = (x) -> {
			Map<String,Integer> names = new HashMap<>();
			for (RollingStoneAlbum entry : x) {
				names.put(entry.getAlbum(), entry.getAlbum().length());
			}
			return names;
		};
		Map<String,Integer> names = function.apply(list);
		
	}
	
	

}

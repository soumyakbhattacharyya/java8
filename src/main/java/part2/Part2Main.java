package part2;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import common.model.RollingStoneAlbum;
import common.utility.CSVReader;

public class Part2Main {

	public static void main(String[] args) throws Exception {
		
		List<RollingStoneAlbum> list = CSVReader.readCSV();	
		functionExample2(list);
	
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
	
	public static void functionExample1(List<RollingStoneAlbum> list) {
		Function<List<RollingStoneAlbum>, Map<String,Integer>> function = (x) -> {
			Map<String,Integer> names = new HashMap<>();
			for (RollingStoneAlbum entry : x) {
				names.put(entry.getAlbum(), entry.getAlbum().length());
			}
			return names;
		};
		Map<String,Integer> names = function.apply(list);
		
	}
	
	public static void functionExample2(List<RollingStoneAlbum> list) {
		Function<List<RollingStoneAlbum>, Map<String, Integer>> buildArtistsVsNameCollection = (List<RollingStoneAlbum> x) -> {
			Map<String, Integer> names = new HashMap<>();
			for (RollingStoneAlbum entry : x) {
				if (null == names.get(entry.getArtist())) {
					names.put(entry.getArtist(), entry.getArtist().length());
				}
			}
			return names;
		};
		Function<Map<String, Integer>, Double> findAverageLength = (x) -> {
			double numArtists = x.keySet().size();
			double totalLength = 0;
			for (Entry<String,Integer> entry : x.entrySet()) {
				totalLength = totalLength + entry.getValue();
			}
			return totalLength/numArtists;
		};

		Double averageLength = findAverageLength.compose(buildArtistsVsNameCollection).apply(list);
		System.out.println("average length is :"+averageLength);

	}
	
	public static void stuff(List<RollingStoneAlbum> list) {
		Function<RollingStoneAlbum, String> funcEmpToString = (RollingStoneAlbum e) -> {
			return e.getAlbum();
		};
		Function<String, String> initialFunction = (String s) -> s.substring(0, 1);
		List<String> empNameListInitials = convertEmpListToNamesList(list, funcEmpToString.andThen(initialFunction));
		empNameListInitials.forEach(str -> {
			System.out.print(" " + str);
		});
	}

	public static List<String> convertEmpListToNamesList(List<RollingStoneAlbum> albumList,
			Function<RollingStoneAlbum, String> funcEmpToString) {
		List<String> albumNameList = new ArrayList<String>();
		for (RollingStoneAlbum emp : albumList) {
			albumNameList.add(funcEmpToString.apply(emp));
		}
		return albumNameList;
	}
	

}

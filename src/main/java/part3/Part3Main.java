package part3;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import common.model.RollingStoneAlbum;
import common.utility.CSVReader;

public class Part3Main {

	public static void main(String[] args) throws Exception {

		List<RollingStoneAlbum> list = CSVReader.readCSV();
		reduceExample(list);

	}

	public static void externalIterator(List<RollingStoneAlbum> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static void internalIterator(List<RollingStoneAlbum> list) {

		Stream<RollingStoneAlbum> stream = list.stream();
	}

	public static void filterExample(List<RollingStoneAlbum> list) {

		System.out.println("Size before filtering " + list.size());
		List<RollingStoneAlbum> collect = list.stream().filter(x -> x.getGenre().contains("Pop")).collect(Collectors.toList());
		System.out.println("Size after filtering " + collect.size());

	}
	
	public static void mapExample(List<RollingStoneAlbum> list) {

		System.out.println("Size before mapping " + list.size());
		Set<String> collect = list.stream().map(x -> x.getArtist()).collect(Collectors.toSet());
		System.out.println("Size after mapping " + collect.size());

	}
	
	public static void maxExample(List<RollingStoneAlbum> list) {
		
		Comparator<RollingStoneAlbum> albumComparator = Comparator.comparing(x -> x.getAlbum(), 
				                                                             (s1, s2) -> {
			                                                                              return (new Integer(s1.length())).compareTo(new Integer(s2.length()));
		                                                                                 }
		                                                                    );

		RollingStoneAlbum rollingStoneAlbum = list.stream().max(albumComparator).get();
		System.out.println("Album with longest name " + rollingStoneAlbum.getAlbum());

	}
	
	public static void reduceExample(List<RollingStoneAlbum> list) {

		int totalAlbumNameLength = list.stream().map(x -> x.getAlbum().length()).reduce(0,  (acc,element) -> acc + element);
		long totalNumberOfAlbums = list.stream().count();
		System.out.println("Average length of album names" + totalAlbumNameLength/totalNumberOfAlbums);

	}

	

}

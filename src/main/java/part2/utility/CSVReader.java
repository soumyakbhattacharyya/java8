package part2.utility;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import part2.model.RollingStoneAlbum;

public class CSVReader {

	private static final String CSV_FILE = "src/main/resources/albumlist.csv";

	public static List<RollingStoneAlbum> readCSV() throws Exception {

		List<RollingStoneAlbum> list = new ArrayList<>();
		ICsvBeanReader beanReader = null;

		try {
			beanReader = new CsvBeanReader(new FileReader(CSV_FILE), CsvPreference.STANDARD_PREFERENCE);

			// the header elements are used to map the values to the bean (names must match)
			final String[] header = beanReader.getHeader(true);

			RollingStoneAlbum rollingStoneAlbum;
			while ((rollingStoneAlbum = beanReader.read(RollingStoneAlbum.class, header)) != null) {
				list.add(rollingStoneAlbum);
			}

		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}

		return list;
	}

}

package ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter{
	private String suffix;

	SuffixFilter(String suffix) {
		this.suffix = suffix;
	}

	public boolean accept(File dir, String name) {
		name = name.split("\\.")[0];
		return name.endsWith(suffix);
	}
}
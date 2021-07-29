package org.ahocorasick;

import jnr.ffi.LibraryLoader;

import java.util.List;

public class AhoCorasick {
    private LibC libc;

    public AhoCorasick() {
        libc = LibraryLoader.create(LibC.class).load("ahocorasick-rust");
    }

    public interface LibC {
        List<Tuple<Integer, Integer>> match(List<String> keywords, String haystack);
    }

    public List<Tuple<Integer, Integer>> match(List<String> keywords, String haystack) {
        return libc.match(keywords, haystack);
    }
}

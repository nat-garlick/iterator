package edu.io;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TextSource implements Iterable<String>{
    private final String txt;
    public TextSource(String txt){
        this.txt=txt;        
    }

    @Override
    public Iterator<String> iterator() {
        return new CharacterIterator(txt);
    }
    public Iterator<String> wordIterator(){
        return new WordIterator(txt);
    }

    private static class CharacterIterator implements Iterator<String>{
        private String txt;
        private int i=0;
        public CharacterIterator(String txt){
        this.txt=txt;        
    }
        @Override
        public boolean hasNext() {
            if (i<txt.length() && !txt.isEmpty())return true;
            return false;
        }
        @Override
        public String next() {
            if(hasNext())
                return txt.substring(i,++i);
            throw new NoSuchElementException();
        }
    }

    private static class WordIterator implements Iterator<String>{
        private String txt;
        private int i=0;
        private String[] words;

        public WordIterator(String txt){
            this.txt=txt;
            this.words=txt.split(" ");
        }

        @Override
        public boolean hasNext() {
            if (i<words.length && !txt.isEmpty())return true;
            return false;
        }
        @Override
        public String next() {
            if(hasNext())
                return words[i++];
            throw new NoSuchElementException();
        }
    }
}

/*
Dieter Jason Matthew 5/12/22
Notes class
attributes: chapter, contents
These are notes which will be used in the study portion of the project
 */
package pmproject;

/**
 *
 * @author jason
 */
public class notes {
    
    private int chapter;
    private String contents;

    /**
     * notes constructor
     * no parameters
     */
    public notes(){
        chapter = 0;
        contents = "";
    }
    /**
     * secondary constructor
     * includes all parameters
     * @param c - the chapter
     * @param cont - contents
     */
    public notes (int c, String cont){
        this();
        chapter = c;
        contents = cont;
    }
    /**
     * accessor for the chapter number
     * @return - chapter number
     */
    public int getChapter(){
        return chapter;
    }
    /**
     * mutator for the chapter number
     * @param c - new chapter number
     */
    public void setChapter(int c){
        chapter = c;
    }
    /**
     * accessor for the contents (string)
     * @return - contents
     */
    public String getContents(){
        return contents;
    }
    /**
     * mutator for the contents
     * @param c - new contents
     */
    public void setContents(String c){
        contents = c;
    }

    /**
     * to string method returns string with all the info on the note
     * @return - string with the info
     */
    public String toString(){
        return "Chapter: " + chapter + "\nContents: " + contents; 
    }
    /**
     * equals method checks if two notes are the same
     * @param sample - note being checked
     * @return - boolean of whether they are the same
     */
    public boolean equals(notes sample){
        return (chapter == sample.getChapter() && contents.equalsIgnoreCase(sample.getContents()));
    }
    /**
     * clone method returns an identical note
     * @return - cloned note
     */
    public notes clone(){
        return new notes(chapter, contents);
    }
    
}

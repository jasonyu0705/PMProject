/*
Matthew Yu
11/05/2022

commented by dieter dieter dieter
 */
package pmproject;

/**
 *
 * @author jason
 */
public class notes {
    
    private int chapter;
    private String contents;
    private String imagePath;
    /**
     * notes constructor
     * no parameters
     */
    public notes(){
        chapter = 0;
        contents = "";
        imagePath = "";
    }
    /**
     * secondary constructor
     * includes all parameters
     * @param c - the chapter
     * @param cont - contents
     * @param image - image file location
     */
    public notes (int c, String cont, String image){
        this();
        chapter = c;
        contents = cont;
        imagePath = image;
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
     * accessor for the image path
     * @return - the image path
     */
    public String getImagePath(){
        return imagePath;
    }
    /**
     * mutator for the image path
     * @param i - new image path
     */
    public void setImagePath(String i){
        imagePath = i;
    }
    /**
     * to string method returns string with all the info on the note
     * @return - string with the info
     */
    public String toString(){
        return "Chapter: " + chapter + "Contents: " + contents; //no need for image path because user doesn't care
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
        return new notes(chapter, contents, imagePath);
    }
    
}

/*
Matthew Yu
11/05/2022

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
    
    public notes(){
        chapter = 0;
        contents = "";
        imagePath = "";
    }
    
    public notes (int c, String cont, String image){
        super();
        chapter = c;
        contents = cont;
        imagePath = image;
    }
    
    public int getChapter(){
        return chapter;
    }
    
    public void setChapter(int c){
        chapter = c;
    }
    
    public String getContents(){
        return contents;
    }
    
    public void setContents(String c){
        contents = c;
    }
    
    public String getImagePath(){
        return imagePath;
    }
    
    public void setImagePath(String i){
        imagePath = i;
    }
    
    public String toString(){
        return "Chapter: " + chapter + "Contents: " + contents; //no need for image path because user doesn't care
    }
    
    public boolean equals(notes sample){
        return (chapter == sample.getChapter() && contents.equalsIgnoreCase(sample.getContents()));
    }
    
    public notes clone(){
        return new notes(chapter, contents, imagePath);
    }
    
}

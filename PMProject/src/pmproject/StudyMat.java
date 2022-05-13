/*
Dieter Jason Matthew 5/12/22
Study material frame class
displays the contents of any chapter and lets the user choose between them
uses the notes object
 */
package pmproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jason
 */
public class StudyMat extends javax.swing.JFrame {

    private PmProject menu;
    private notes[] textbook; //array of notes to store information of each chapter

    /**
     * Creates new form StudyMat
     */
    public StudyMat(PmProject p) {
        initComponents();
        menu = p;

        try { //try to find study notes text file and create scanner object in it
            File f = new File("src/pmproject/studyNotes.txt");
            Scanner s = new Scanner(f); 
            textbook = new notes[10]; //initialize array of size 10 to hold the 10 chapters
            String msg = ""; //information of chapter as string
            int chapter; //chapter/topic number
                    
            //for each index of the array of notes
            for (int i = 0; i < textbook.length; i++){
                chapter = Integer.parseInt(s.nextLine()); //chapter number are the first lines
                for (int j = 0; j < 7; j++) { //for each line of the chapter's contents(7 lines of content)
                    msg += s.nextLine() + "\n"; //add it to the string message with a new line. This avoids having too much info on the same line
                }
                textbook[i]  = new notes(chapter, msg); //instantiate new textbook object at index of notes array
                msg = ""; //reset message to nothing
            }
            
            
        } catch (FileNotFoundException e) { //otherwise output error message
            txtAstudy.setText("Error: " + e);
        }
        
        btnEdit.setEnabled(false); //set enabled button to false as user hasn't viewed any chapter when starting
        
    }
    
    /**
     * Helper method to output contents of a chapter
     */
    private void outputChapter(){
        int viewChap = cBoxChapter.getSelectedIndex(); //get user's selected chapter from combo box to determine which index of notes array to output to user
        txtAstudy.setText(textbook[viewChap].toString()); //output chapter contents and chapter number in text area by invoking toString method from notes class
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAstudy = new javax.swing.JTextArea();
        lblUnitToStudy = new javax.swing.JLabel();
        cBoxChapter = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Back to Menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtAstudy.setColumns(20);
        txtAstudy.setRows(5);
        jScrollPane1.setViewportView(txtAstudy);

        lblUnitToStudy.setText("Unit of Study:");

        cBoxChapter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Overview", "Success", "Waterfall Model", "Analysis", "Design", "Implementation", "Testing/Integration", "Maintenance", "Gantt Chart", "Universal Modeling Language" }));

        btnEdit.setText("Save Edits");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUnitToStudy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                        .addComponent(btnEdit)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnitToStudy)
                    .addComponent(cBoxChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnView))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        menu.setVisible(true); //let user see menu jframe
        this.setVisible(false); //user doesn't want to see notes jframe anymore
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        outputChapter(); //invoke outputChapter method to output information of user selected chapter
        btnEdit.setEnabled(true); //user selected a chapter to look at, enable edit button so they can make edits
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int chapNum = cBoxChapter.getSelectedIndex(); //get user's current chapter by seeing what combo box number selected
        String contents = txtAstudy.getText(); //store string in text area within a variable
        contents = contents.substring(21); //we only want the contents of the chapter, so we leave out the chapter and contents header and the chapter number, which is always the first 20 characters
        textbook[chapNum].setContents(contents); //set the current chapter's contents to whatever user edited using setContents method from notes class
    }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cBoxChapter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUnitToStudy;
    private javax.swing.JTextArea txtAstudy;
    // End of variables declaration//GEN-END:variables

}

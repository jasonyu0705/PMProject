/*
Matthew Dieter Jason
12/05/2022
JFrame for quiz for user to test
 */
package pmproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jason
 */
public class Quiz extends javax.swing.JFrame {
    // instantiate variables
    private PmProject menu; //main menu window
    public Question[] questions = new Question[10]; //array of question objects. Assign size 10 to hold the 10 multiple choice questions
    public String theQuestion; //question as string
    private String optionOne; //first option
    private String optionTwo; //second option
    private String optionThree; //third option
    private String optionFour; //fourth option
    private int ansIndex; //index of correct answer
    Question q; //question object
    int counter = 0; //index of question number currently on as integer
    int rightAnswer = 0; //counter for right answers
    int wrongAnswer = 0; //counter for wrong answers
    String msg = ""; //message to display


    /**
     * Creates new form Quiz
     */
    public Quiz(PmProject p) {
        initComponents();
        try {// create the try to the try catch statement
            //instantiate a new file
            File f = new File("src\\pmproject\\quizQuestions.txt");
            // instantiate a new scanner
            Scanner s = new Scanner(f);
            // read through the file with a for loop
            for (int i = 0; i < 10; i++) {
                /**
                 * gonna leave spaces between questions for easy viewing.
                 * Remember to work around this in program Sample question
                 * Option 1 Option 2 Option 3 Option 4 Index of answer*
                 */
                // readd all the info neede for one question object
                theQuestion = s.nextLine();
                optionOne = s.nextLine();
                optionTwo = s.nextLine();
                optionThree = s.nextLine();
                optionFour = s.nextLine();
                ansIndex = Integer.parseInt(s.nextLine());
                
               //create a new uquestion object
                q = new Question(theQuestion, optionOne, optionTwo, optionThree, optionFour, ansIndex, 5);
                System.out.println("Answer: " + ansIndex);
                // add the question object to the array of questions
                questions[i] = q;
                //NOTE THIS WILL NOT WORK UNTIL THE DATA FILE IS FINISHED
            }
        } catch (FileNotFoundException e) { //otherwise, output error message
            txtAResults.setText("Error:" + e);
        }
        
        menu = p;
        // disable some buttons so that the program wont error
        rBtnA.setEnabled(false);
        rBtnB.setEnabled(false);
        rBtnC.setEnabled(false);
        rBtnD.setEnabled(false);
        btnNext.setEnabled(false);
        btnBack2.setEnabled(false);
        btnCheck.setEnabled(false);

    }
/**
 * show the info on each of the questions
 */
    public void showInfo() {
        // set the text to the 
        txtFieldQuestion.setText(questions[counter].getQuestion());
        rBtnA.setText(questions[counter].getOption(1));
        rBtnB.setText(questions[counter].getOption(2));
        rBtnC.setText(questions[counter].getOption(3));
        rBtnD.setText(questions[counter].getOption(4));
    }
/**
 * reset the buttons so that they are all de selected 
 */
    public void reset() {
        rBtnA.setSelected(false);
        rBtnB.setSelected(false);
        rBtnC.setSelected(false);
        rBtnD.setSelected(false);
        if (counter == 10) {
            btnNext.setEnabled(false);
        }

    }

    /**
     * Set user input for answer
     */
    public void getAns() {
        if (rBtnA.isSelected() == true) { //if user selects first radio button
            questions[counter].setUserAnswer(0); //set user answer to 0 through setUserAnswer method in question class
        } else if (rBtnB.isSelected() == true) { //if user selects second radio button
            questions[counter].setUserAnswer(1); //set user answer to 1 through setUserAnswer method in question class
        } else if (rBtnC.isSelected() == true) { //if user selects third radio button
            questions[counter].setUserAnswer(2);//set user answer to 2 through setUserAnswer method in question class
        } else if (rBtnD.isSelected() == true){ //if user selects fourth radio button
            questions[counter].setUserAnswer(3); //set user answer to 3 through setUserAnswer method in question class
        }

    }
    
    /**
     * Keep track of right and wrong answers during quiz
     * @param counter 
     */
    public void checkAns(int counter) {
        //invoke correct method from question class to check if user answer same as correct answer
        if (questions[counter].correct() == true) { //if same
            rightAnswer = rightAnswer + 1; //add one to right answer counter
            msg = msg + "Question #" + (counter + 1 ) + ") correct!\n"; //update message with right answer message
        } else { //if different
            wrongAnswer = wrongAnswer + 1; //add one to wrong answer counter
            msg = msg + "Question #" + (counter + 1) + ") incorrect! The correct answer is answer number " + (questions[counter].getAnswer() + 1) + "\n"; //update message with wrong answer message
        }
        btnCheck.setEnabled(false); //set check answer button to disabled as we don't need user to check answers again

    }
    
    /**
     * Disable and enable next and back buttons depending on what question user on
     */
    public void checkButtonStat() {
        if (counter == 9) { //if user on last question
            btnNext.setEnabled(false); //disable next button as no question after
            btnCheck.setEnabled(true); //enable check button as they looked at all questions
        } else { //if not on last question
            btnNext.setEnabled(true); //enable next button as they can move to next question
        }
        if (counter == 0) { //if user on first question
            btnBack2.setEnabled(false); //disable back button as no previous question
        } else { //otherwise, not on first question
            btnBack2.setEnabled(true); //enable back button as there is button before
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnBack = new javax.swing.JButton();
        rBtnA = new javax.swing.JRadioButton();
        rBtnB = new javax.swing.JRadioButton();
        rBtnC = new javax.swing.JRadioButton();
        rBtnD = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        txtFieldQuestion = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAResults = new javax.swing.JTextArea();
        lblResults = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Back to Menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        buttonGroup1.add(rBtnA);

        buttonGroup1.add(rBtnB);

        buttonGroup1.add(rBtnC);

        buttonGroup1.add(rBtnD);
        rBtnD.setToolTipText("");

        lblQuestion.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblQuestion.setText("Question 1");

        txtFieldQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldQuestionActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        txtAResults.setColumns(20);
        txtAResults.setRows(5);
        jScrollPane1.setViewportView(txtAResults);

        lblResults.setText("Test Results:");

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnCheck.setText("Check your work");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnBack2.setText("Back");
        btnBack2.setToolTipText("");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBack)
                                    .addComponent(lblResults)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(btnBack2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNext)
                                        .addGap(95, 95, 95)
                                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFieldQuestion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rBtnA)
                                    .addComponent(rBtnB)
                                    .addComponent(rBtnC)
                                    .addComponent(rBtnD)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblQuestion)
                                        .addGap(112, 112, 112)
                                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 238, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnC)
                        .addGap(12, 12, 12)
                        .addComponent(rBtnD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnCheck)
                            .addComponent(btnBack2))
                        .addGap(36, 36, 36)
                        .addComponent(lblResults)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        menu.setVisible(true); //make main menu jframe visible to user
        this.setVisible(false); //make quiz jframe invisible to user
        
        //set all the quiz feautre buttons to disabled in case user returns to quiz. They want a fresh start
        rBtnA.setEnabled(false); 
        rBtnB.setEnabled(false);
        rBtnC.setEnabled(false);
        rBtnD.setEnabled(false);
        btnNext.setEnabled(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFieldQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldQuestionActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        counter = counter + 1; //add one to index

        showInfo(); //invoke showInfo method to show info about question
        //set all option radio buttons to disabled so user can choose
        rBtnA.setSelected(false);
        rBtnB.setSelected(false);
        rBtnC.setSelected(false);
        rBtnD.setSelected(false);
        btnStart.setEnabled(false); //set start button to disabled because user already started quiz
        lblQuestion.setText("Question " + (counter + 1)); //output question number on question label. Counter is index based so counting numbers is one more
        checkButtonStat(); //invoke checkButtonStat method to check current question user on and disable next and back buttons if necessary
        getAns(); //invoke getAns method to set user answer
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        //set all quiz buttons to enabled when startning quiz
        rBtnA.setEnabled(true); 
        rBtnB.setEnabled(true);
        rBtnC.setEnabled(true);
        rBtnD.setEnabled(true);
        btnNext.setEnabled(true);
        showInfo(); //invoke showInfo method to show question information

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        for (int i = 0; i < 10; i++) { //for each question of quiz
            checkAns(i); //invoke checkAns to check if user answr correct
        }
        txtAResults.setText(msg); //put message of results in results text area 

    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        counter = counter - 1; //take one off index
        System.out.println(counter); //output count        
        showInfo(); //invoke showInfo method to show current index question info
        lblQuestion.setText("Question " + (counter + 1)); //update question number
        checkButtonStat(); //invoke checkButtonStat method to check which buttons to enable and disable
        getAns(); //invoke getAns method user answer
    }//GEN-LAST:event_btnBack2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnStart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblResults;
    private javax.swing.JRadioButton rBtnA;
    private javax.swing.JRadioButton rBtnB;
    private javax.swing.JRadioButton rBtnC;
    private javax.swing.JRadioButton rBtnD;
    private javax.swing.JTextArea txtAResults;
    private javax.swing.JTextField txtFieldQuestion;
    // End of variables declaration//GEN-END:variables
}

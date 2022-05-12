/*
wdsav
 */
package pmproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jason
 */
public class Quiz extends javax.swing.JFrame {

    private PmProject menu;

    public Question[] questions = new Question[10];
    public String theQuestion;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private int ansIndex;
    private String placeholder;
    Question q;
    int counter = 0;
    int rightAnswer = 0;
    int wrongAnswer = 0;

    /**
     * Creates new form Quiz
     */
    public Quiz(PmProject p) {
        initComponents();
        try {
            File f = new File("src\\pmproject\\quizQuestions.txt");
            Scanner s = new Scanner(f);
            for (int i = 0; i < 10; i++) {
                /**
                 * gonna leave spaces between questions for easy viewing.
                 * Remember to work around this in program Sample question
                 * Option 1 Option 2 Option 3 Option 4 Index of answer*
                 */
                theQuestion = s.nextLine();
                optionOne = s.nextLine();
                optionTwo = s.nextLine();
                optionThree = s.nextLine();
                optionFour = s.nextLine();
                ansIndex = Integer.parseInt(s.nextLine());
                //placeholder = s.nextLine();
                // idk y but the spaces in the file messedup reading it
                // if you can fix it , you can re add the spaces
                q = new Question(theQuestion, optionOne, optionTwo, optionThree, optionFour, ansIndex, 4);
                questions[i] = q;
                //NOTE THIS WILL NOT WORK UNTIL THE DATA FILE IS FINISHED
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error:" + e);
        }
        menu = p;
        rBtnA.setEnabled(false);
        rBtnB.setEnabled(false);
        rBtnC.setEnabled(false);
        rBtnD.setEnabled(false);
        btnNext.setEnabled(false);
        btnBack2.setEnabled(false);
        btnCheck.setEnabled(false);

    }

    public void showInfo() {
        txtFieldQuestion.setText(questions[counter].getQuestion());
        rBtnA.setText(questions[counter].getOption(1));
        rBtnB.setText(questions[counter].getOption(2));
        rBtnC.setText(questions[counter].getOption(3));
        rBtnD.setText(questions[counter].getOption(4));
    }

    public void reset() {
        rBtnA.setSelected(false);
        rBtnB.setSelected(false);
        rBtnC.setSelected(false);
        rBtnD.setSelected(false);
        if (counter == 10) {
            btnNext.setEnabled(false);
        }

    }

    public void getAns() {
        if (rBtnA.isSelected() == true) {
            questions[counter].setUserAnswer(0);

        } else if (rBtnB.isSelected() == true) {
            questions[counter].setUserAnswer(1);
        } else if (rBtnC.isSelected() == true) {
            questions[counter].setUserAnswer(2);
        } else {
            questions[counter].setUserAnswer(3);
        }
        System.out.println(questions[counter].getUserAnswer()+" ua");
        System.out.println(questions[counter].getAnswer()+" a");

    }

    public void checkAns(int counter) {
        if (questions[counter].correct() == true) {
            rightAnswer = rightAnswer + 1;
            System.out.println(rightAnswer + "right");

        } else {
            wrongAnswer = wrongAnswer + 1;
            System.out.println(wrongAnswer + "wrong");
        }
        btnCheck.setEnabled(false);

    }

    public void checkButtonStat() {
        if (counter == 9) {
            btnNext.setEnabled(false);
            btnCheck.setEnabled(true);
        } else {
            btnNext.setEnabled(true);
        }
        if (counter == 0) {
            btnBack2.setEnabled(false);
        } else {
            btnBack2.setEnabled(true);
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
        jTextArea1 = new javax.swing.JTextArea();
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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
        menu.setVisible(true);
        this.setVisible(false);

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
        counter = counter + 1;

        showInfo();
        rBtnA.setSelected(false);
        rBtnB.setSelected(false);
        rBtnC.setSelected(false);
        rBtnD.setSelected(false);
        btnStart.setEnabled(false);
        lblQuestion.setText("Question " + (counter + 1));
        checkButtonStat();
        getAns();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        rBtnA.setEnabled(true);
        rBtnB.setEnabled(true);
        rBtnC.setEnabled(true);
        rBtnD.setEnabled(true);
        btnNext.setEnabled(true);
        showInfo();

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        String msg = "";
        for (int i = 0; i < 10; i++) {
            checkAns(i);
        }
        for (int i = 0; i < 10; i++) {
            
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        counter = counter - 1;
        System.out.println(counter);
        showInfo();
        lblQuestion.setText("Question " + (counter + 1));
        checkButtonStat();
        getAns();
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblResults;
    private javax.swing.JRadioButton rBtnA;
    private javax.swing.JRadioButton rBtnB;
    private javax.swing.JRadioButton rBtnC;
    private javax.swing.JRadioButton rBtnD;
    private javax.swing.JTextField txtFieldQuestion;
    // End of variables declaration//GEN-END:variables
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class OnlineVotingSystemGUI {
    private HashMap<String, Integer> candidates;
    private JFrame frame;
    private JTextField candidateField;
    private JTextField voteField;
    private JTextArea resultArea;

    public OnlineVotingSystemGUI() {
        candidates = new HashMap<>();
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Online Voting System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Label and text field to add a candidate
        JLabel addCandidateLabel = new JLabel("Add Candidate:");
        addCandidateLabel.setBounds(20, 20, 100, 25);
        frame.add(addCandidateLabel);

        candidateField = new JTextField();
        candidateField.setBounds(130, 20, 150, 25);
        frame.add(candidateField);

        JButton addCandidateButton = new JButton("Add");
        addCandidateButton.setBounds(290, 20, 80, 25);
        frame.add(addCandidateButton);

        // Label and text field to cast a vote
        JLabel voteLabel = new JLabel("Vote for:");
        voteLabel.setBounds(20, 60, 100, 25);
        frame.add(voteLabel);

        voteField = new JTextField();
        voteField.setBounds(130, 60, 150, 25);
        frame.add(voteField);

        JButton voteButton = new JButton("Vote");
        voteButton.setBounds(290, 60, 80, 25);
        frame.add(voteButton);

        // Button to display results
        JButton resultsButton = new JButton("Show Results");
        resultsButton.setBounds(20, 100, 350, 25);
        frame.add(resultsButton);

        // Text area to display results
        resultArea = new JTextArea();
        resultArea.setBounds(20, 140, 350, 200);
        resultArea.setEditable(false);
        frame.add(resultArea);

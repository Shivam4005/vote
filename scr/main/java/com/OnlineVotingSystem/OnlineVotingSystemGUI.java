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

        // Add action listeners
        addCandidateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String candidateName = candidateField.getText().trim();
                if (!candidateName.isEmpty()) {
                    addCandidate(candidateName);
                    candidateField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Candidate name cannot be empty.");
                }
            }
        });

        voteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String voteFor = voteField.getText().trim();
                if (!voteFor.isEmpty()) {
                    castVote(voteFor);
                    voteField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Vote field cannot be empty.");
                }
            }
        });

        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayResults();
            }
        });

        frame.setVisible(true);
    }

    private void addCandidate(String candidateName) {
        if (!candidates.containsKey(candidateName)) {
            candidates.put(candidateName, 0);
            JOptionPane.showMessageDialog(frame, "Candidate " + candidateName + " added successfully.");
        } else {
            JOptionPane.showMessageDialog(frame, "Candidate " + candidateName + " already exists.");
        }
    }

    private void castVote(String candidateName) {
        if (candidates.containsKey(candidateName)) {
            candidates.put(candidateName, candidates.get(candidateName) + 1);
            JOptionPane.showMessageDialog(frame, "Vote casted successfully for " + candidateName);
        } else {
            JOptionPane.showMessageDialog(frame, "Candidate " + candidateName + " not found.");
        }
    }

    private void displayResults() {
        StringBuilder results = new StringBuilder("Voting Results:\n");
        for (String candidate : candidates.keySet()) {
            results.append(candidate).append(": ").append(candidates.get(candidate)).append(" votes\n");
        }
        resultArea.setText(results.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineVotingSystemGUI());
    }
}

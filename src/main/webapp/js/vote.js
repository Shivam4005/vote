let votes = {
    'Candidate A': 0,
    'Candidate B': 0,
    'Candidate C': 0,
    'Candidate D': 0
};

const voteButton = document.getElementById('voteButton');
const resultSection = document.getElementById('resultSection');
const resetButton = document.getElementById('resetButton');

voteButton.addEventListener('click', () => {
    // Get the selected candidate
    const selectedCandidate = document.querySelector('input[name="candidate"]:checked');

    if (selectedCandidate) {
        // Increase the vote count for the selected candidate
        const candidate = selectedCandidate.value;
        votes[candidate]++;

        // Show the results
        showResults();
    } else {
        alert('Please select a candidate!');
    }
});

resetButton.addEventListener('click', () => {
    // Reset votes
    votes = {
        'Candidate A': 0,
        'Candidate B': 0,
        'Candidate C': 0,
        'Candidate D': 0
    };
    
    // Reset the UI
    showResults();
});

function showResults() {
    // Display the result section
    resultSection.style.display = 'block';

    // Update the vote counts
    document.getElementById('votesA').textContent = votes['Candidate A'];
    document.getElementById('votesB').textContent = votes['Candidate B'];
    document.getElementById('votesC').textContent = votes['Candidate C'];
    document.getElementById('votesD').textContent = votes['Candidate D'];
}

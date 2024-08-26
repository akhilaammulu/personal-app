document.addEventListener("DOMContentLoaded", function() {
    // Fetch and display data for different categories
    function fetchAndDisplayData() {
        Promise.all([
            fetch('/api/budgets').then(res => res.json()),
            fetch('/api/currencies').then(res => res.json()),
            fetch('/api/debts').then(res => res.json()),
            fetch('/expenses').then(res => res.json()),
            fetch('/api/transactions').then(res => res.json()),
            fetch('/financial-goals').then(res => res.json()),
            fetch('/api/users').then(res => res.json()),
            fetch('/api/recurring-transactions').then(res => res.json()),
            fetch('/api/savings-accounts').then(res => res.json()),
            fetch('/api/taxes').then(res => res.json())
        ]).then(data => {
            const [budgets, currencies, debts, expenses, transactions, financialGoals, users, recurringTransactions, savingsAccounts, taxes] = data;

            // Example Chart: Budgets vs Expenses (Bar Chart)
            const ctx = document.getElementById('financialChart').getContext('2d');
            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: budgets.map(budget => budget.name),
                    datasets: [
                        {
                            label: 'Budgets',
                            data: budgets.map(budget => budget.amount),
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderColor: 'rgba(75, 192, 192, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'Expenses',
                            data: expenses.map(expense => expense.amount),
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }
                    ]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });

            // Example Chart: Debts Breakdown (Pie Chart)
            const ctx2 = document.getElementById('debtsChart').getContext('2d');
            new Chart(ctx2, {
                type: 'pie',
                data: {
                    labels: debts.map(debt => debt.name),
                    datasets: [{
                        label: 'Debts',
                        data: debts.map(debt => debt.amount),
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                    }]
                }
            });

            // Example Chart: Financial Goals Progress (Line Chart)
            const ctx3 = document.getElementById('financialGoalsChart').getContext('2d');
            new Chart(ctx3, {
                type: 'line',
                data: {
                    labels: financialGoals.map(goal => goal.name),
                    datasets: [{
                        label: 'Financial Goals Progress',
                        data: financialGoals.map(goal => goal.progress),
                        fill: false,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        tension: 0.1
                    }]
                }
            });

            // Additional charts can be created similarly for other data like users, transactions, etc.
        }).catch(error => {
            console.error('Error fetching data:', error);
        });
    }

    fetchAndDisplayData();
});

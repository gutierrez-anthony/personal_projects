/*
    Javascript logic for the video games dataset page.
    Author: Anthony Gutierrez
    File: program.js
    Date: 3/7/2022
*/

//Print out our data set
// console.log(games);


let section = document.getElementById('left-col');
let headerPara = document.querySelector('header p');
// Print out the length of the dataset on the top of the page
headerPara.innerText = `This library has data about video games, including their play time and sales. There are ${games.length} different video games in the dataset.`;

let list = document.getElementById('facts');

// Use functions and add the calculated results to a list using quantitative data
list.innerHTML += '<li>The console with the most games is the ' + mostConsoleGame() + '</li>';
list.innerHTML += '<li>The game with the highest review score is ' + highestReviewScore() + '</li>';
list.innerHTML += '<li>The average used price for all the games is $' + averageTotalPrice() + '</li>';

// Create the elements that are changed on the page
let gameTitle = document.createElement('h2');
let gameFeatures = document.createElement('button');
let gameMetadata = document.createElement('button');
let gameMetrics = document.createElement('button');
let releaseData = document.createElement('button');
let gameLength = document.createElement('button');

let featureElements = document.createElement('p');
let metaDataElements = document.createElement('p');
let metricsElements = document.createElement('p');
let releaseDataElements = document.createElement('p');

let lengthPlayStyles = document.createElement('p');
let lengthComplete = document.createElement('p');
let lengthMainStory = document.createElement('p');
let lengthExtras = document.createElement('p');


//get access to our buttons
let previous = document.getElementById("previous");
let next = document.getElementById("next");

//the index of the current object shown
//on the web page
let index = 0;
display();

//responds to clicks of the "previous" button
previous.onclick = function(event) {
    if(index > 0)
    {
        index--;
    }

    //make sure that index is never less than zero...
    display();
}

//responds to clicks of the "next" button
next.onclick = function() {
    if(index < games.length-1)
    {
        index++
    }

    //make sure that index is never greater than
    //array.length - 1

    display();
}

// Button elements that reveal the data of the specific game
// Each button reveals different types of data
gameFeatures.onclick = function() {
    featureElements.innerText = `Handheld: ${games[index]['Features']['Handheld?']}
                                 Max Players: ${games[index]['Features']['Max Players']}
                                 Multiplatform: ${games[index]['Features']['Multiplatform?']}
                                 Online: ${games[index]['Features']['Online?']}`;
    gameFeatures.appendChild(featureElements);
}
// Whenever the mouse leaves the paragraph box containing the data
// Removes the text info and just shows the button element
gameFeatures.onmouseleave = function() {
    gameFeatures.removeChild(featureElements);
}

gameMetadata.onclick = function() {
    metaDataElements.innerText = `Genres: ${games[index]['Metadata']['Genres']}
                                  Licensed: ${games[index]['Metadata']['Licensed?']}
                                  Publishers: ${games[index]['Metadata']['Publishers']}
                                  Sequel: ${games[index]['Metadata']['Sequel?']}`;
    gameMetadata.appendChild(metaDataElements);
}
gameMetadata.onmouseleave = function() {
    gameMetadata.removeChild(metaDataElements);
}

gameMetrics.onclick = function() {
    metricsElements.innerText = `Review Score: ${games[index]['Metrics']['Review Score']}
                                 Sales: ${games[index]['Metrics']['Sales']}
                                 Used Price: ${games[index]['Metrics']['Used Price']}`;
    gameMetrics.appendChild(metricsElements);
}
gameMetrics.onmouseleave = function() {
    gameMetrics.removeChild(metricsElements);
}

releaseData.onclick = function() {
    releaseDataElements.innerText = `Console: ${games[index]['Release']['Console']}
                                     Rating: ${games[index]['Release']['Rating']}
                                     Re-release: ${games[index]['Release']['Re-release?']}
                                     Year: ${games[index]['Release']['Year']}`;
    releaseData.appendChild(releaseDataElements);
}
releaseData.onmouseleave = function() {
    releaseData.removeChild(releaseDataElements);
}

gameLength.onclick = function() {

    // Length button element had nested objects
    // This shows all the data at once
    // instead of having to click multiple buttons to reveal an object
    lengthPlayStyles.innerText = `All PlayStyles: 
                                    Average: ${games[index]['Length']['All PlayStyles']['Average']}
                                     Leisure: ${games[index]['Length']['All PlayStyles']['Leisure']}
                                     Median: ${games[index]['Length']['All PlayStyles']['Median']}
                                     Polled: ${games[index]['Length']['All PlayStyles']['Polled']}
                                     Rushed: ${games[index]['Length']['All PlayStyles']['Rushed']}`;
    lengthComplete.innerText = `Completionists: 
                                     Average: ${games[index]['Length']['Completionists']['Average']}
                                     Leisure: ${games[index]['Length']['Completionists']['Leisure']}
                                     Median: ${games[index]['Length']['Completionists']['Median']}
                                     Polled: ${games[index]['Length']['Completionists']['Polled']}
                                     Rushed: ${games[index]['Length']['Completionists']['Rushed']}`;
    lengthExtras.innerText = `Main + Extras: 
                                     Average: ${games[index]['Length']['Main + Extras']['Average']}
                                     Leisure: ${games[index]['Length']['Main + Extras']['Leisure']}
                                     Median: ${games[index]['Length']['Main + Extras']['Median']}
                                     Polled: ${games[index]['Length']['Main + Extras']['Polled']}
                                     Rushed: ${games[index]['Length']['Main + Extras']['Rushed']}`;
    lengthMainStory.innerText = `Main Story: 
                                     Average: ${games[index]['Length']['Main Story']['Average']}
                                     Leisure: ${games[index]['Length']['Main Story']['Leisure']}
                                     Median: ${games[index]['Length']['Main Story']['Median']}
                                     Polled: ${games[index]['Length']['Main Story']['Polled']}
                                     Rushed: ${games[index]['Length']['Main Story']['Rushed']}`;

    gameLength.appendChild(lengthPlayStyles);
    gameLength.appendChild(lengthComplete);
    gameLength.appendChild(lengthExtras);
    gameLength.appendChild(lengthMainStory);
}
gameLength.onmouseleave = function() {
    gameLength.removeChild(lengthPlayStyles);
    gameLength.removeChild(lengthComplete);
    gameLength.removeChild(lengthExtras);
    gameLength.removeChild(lengthMainStory);
}
// End of the button elements
///////////////////////////////////////////////////////////////

//shows the current record in the array of records
//at the position within the index variable
function display()
{
    console.log(games[index]);
    console.log(index)
    currentGame();

}
// Takes the index number and shows the game title
// Data from the buttons are empty until the user clicks the button elements
function currentGame()
{
    gameTitle.textContent= games[index]['Title'];
    gameFeatures.textContent= 'Features';
    gameMetadata.textContent= 'Metadata';
    gameMetrics.textContent= 'Metrics';
    releaseData.textContent= 'Release Info';
    gameLength.textContent= 'Length';

    section.appendChild(gameTitle);
    section.appendChild(gameFeatures);
    section.appendChild(gameMetadata);
    section.appendChild(gameMetrics);
    section.appendChild(releaseData);
    section.appendChild(gameLength);
}

function mostConsoleGame()
{
    // Create a temp array to hold the different consoles used
    const consoleList= [];
    for(let i = 0; i < games.length; i++)
    {
        let match = false;
        // Adds the first element in the games file to not make
        // for loop try to go through an empty array and break logic
        if(consoleList.length === 0)
        {
            consoleList.push(games[i]['Release']['Console']);
        }

        for(let n = 0; n < consoleList.length; n++)
        {
            // If the type of console exists in the temp array already
            // mark it as a match
            if(games[i]['Release']['Console'] === consoleList[n])
            {
                match = true;
            }
        }
        // If the console of [i] doesn't exist, add that console to the temp array
        if(match === false)
        {
            consoleList.push(games[i]['Release']['Console']);
        }
    }
    // Counters to keep count of how many of each console exists
    let dsCount = 0;
    let pspCount = 0;
    let x360Count = 0;
    let wiiCount = 0;
    let ps3Count = 0;

    // Make sure code is working properly so far
    //console.log(consoleList);
    for(let i = 0; i < games.length; i++)
    {
        // Hardcoded to count if Nintendo Ds/consoleList[0] is found
        if(games[i]['Release']['Console'] === consoleList[0])
        {
            dsCount++;
        }
        // Hardcoded to count if PSP/consoleList[1] is found
        else if(games[i]['Release']['Console'] === consoleList[1])
        {
            pspCount++;
        }
        // Hardcoded to count if Xbox 360/consoleList[2] is found
        else if(games[i]['Release']['Console'] === consoleList[2])
        {
            x360Count++;
        }
        // Hardcoded to count if Nintendo Wii/consoleList[3] is found
        else if(games[i]['Release']['Console'] === consoleList[3])
        {
            wiiCount++;
        }
        // Hardcoded to count if Playstation 3/consoleList[4] is found
        else if(games[i]['Release']['Console'] === consoleList[4])
        {
            ps3Count++;
        }
    }
    // Create a list of all the counters to run through with a for loop
    let consoleCountList = [dsCount, pspCount, x360Count, wiiCount, ps3Count];
    let maxConsoleCount = 0;
    // Make sure code is working properly so far
    //console.log(dsCount, pspCount, x360Count, wiiCount, ps3Count);

    for(let i = 0; i < consoleCountList.length; i++)
    {
        // Whichever counter is highest becomes the max counter
        if(consoleCountList[i] > maxConsoleCount)
        {
            maxConsoleCount = consoleCountList[i];

        }
    }
    let mostUsedConsole;
    // If the max count equals same amount as one of the console counters
    // mostUsedConsole variable becomes that console used
    // Logic may break if elements in the list are shuffled
    if(maxConsoleCount === dsCount)
    {
        mostUsedConsole = consoleList[0];
    }
    else if(maxConsoleCount === pspCount)
    {
        mostUsedConsole = consoleList[1];
    }
    else if(maxConsoleCount === x360Count)
    {
        mostUsedConsole = consoleList[2];
    }
    else if(maxConsoleCount === wiiCount)
    {
        mostUsedConsole = consoleList[3];
    }
    else if(maxConsoleCount === ps3Count)
    {
        mostUsedConsole = consoleList[4];
    }

    return mostUsedConsole;
}

function highestReviewScore()
{
    let maxReviewScore = 0;
    let highestReviewGame;
    for(let i = 0; i < games.length; i++)
    {
        // Takes the highest review score and returns the corresponding game
        // Does not take into account if multiple games share the same score
        // Uses the first highest score
        if(games[i]['Metrics']['Review Score'] > maxReviewScore)
        {
            maxReviewScore = games[i]['Metrics']['Review Score'];
            highestReviewGame = games[i]['Title'];
        }
    }
    return highestReviewGame;
}

function averageTotalPrice()
{
    let totalGames = 0;
    for(let i = 0; i < games.length; i++)
    {
        totalGames += games[i]['Metrics']['Used Price'];
    }
    // Add all the used prices and divide by number of games, round to the nearest dollar
    return Math.floor(totalGames/games.length);
}
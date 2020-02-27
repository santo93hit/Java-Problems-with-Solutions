import React, {Component} from 'react';// use this when using class based component
// import React, {useState} from 'react'; // use this when using function based component
import './App.css';
// import Person from './Person/Person';
import Button from './component/Button';
// Class Component or Class based Component
// This is a stateful component
var valTest ="";
var numberArray=[];
var operationArray=[];
// var lastIndex = 0;
var result=0;
class App extends Component{

  state = {
    persons : [
      {name : "Anish" , age: 26},
      {name : "Max" , age: 27},
      {name : "Vikash" , age: 39}
    ],
    otherState : 'Some other values'
  }

  switchNameHandler = (newName) => {
    //console.log("Was Clicked");
    // this.state.persons[0].name="MaxiMilian";
    this.setState({
      persons : [
        {name : "Anish Sharma" , age: 26},
        {name : newName , age: 27},
        {name : "Vikash" , age: 29}
      ]
    })
  }

  nameChangeHandler = (event) => {
    this.setState({
      persons : [
        {name : "Anish Sharma" , age: 26},
        {name : event.target.value , age: 27},
        {name : "Vikash" , age: 29}
      ]
    })
  }

  
  getValueHandler = (event) => {
    //parseInt();
    let temp = event.target.innerText;
    if(temp==="+" || temp==="-" || temp==="*" || temp==="/" || temp==="%"){
      debugger;
      if(valTest===""){
         return;
      }
      operationArray.push(temp);
      //let numTemp = parseInt(valTest.substring(lastIndex,valTest.length-1));
      //numberArray.push(numTemp);
      //lastIndex = valTest.length;
    }
    valTest = valTest + temp;
    document.getElementById('calculationArea').innerText=valTest;
    document.getElementById('resultArea').innerText="";
  }

  clearDisplaySection = () => {
    valTest="";
    document.getElementById('calculationArea').innerText="";
    document.getElementById('resultArea').innerText="";
    result=0;
    valTest="";
    numberArray=[];
    operationArray=[];
  }

  calculation = () =>{
    debugger;
    if(operationArray.length===0){
      return;
    }
    //let numTemp = parseInt(valTest.substring(lastIndex));
    //numberArray.push(numTemp);

    numberArray = valTest.trim().split('+').join(',').split('-').join(',').split('*').join(',').split('/').join(',').split('%').join(',').split(',');
    if(numberArray.length < 2 || (numberArray.length === 2 && numberArray[1] === "")){
      return;
    }
    // const result = numberArray.map(v =>{
    //   result = result + v;
    // });

    

    // for(const [i,v] of numberArray.entries()){
    //     result = result + v;
    // }
    // let action = operationArray[0];
    result = parseInt(numberArray[0]);
    for (let i = 0; i < operationArray.length; i++) {
    //for(var oparation of operationArray){
      switch(operationArray[i]) {
        case '+':
          result = this.add(result,numberArray[i+1]);
          break;
        case '-':
          result = this.sub(result,numberArray[i+1]);
          break;
        case '*':
          result = this.mul(result,numberArray[i+1]);
          break;
        case '/':
          result = this.div(result,numberArray[i+1]);
          break;
        case '%':
          result = this.rem(result,numberArray[i+1]);
          break;
        default:
          return 'foo';
      }
    }
    
    document.getElementById('resultArea').innerText=result;
    result=0;
    //valTest="";
    numberArray=[];
    //operationArray=[];
    // lastIndex=0;
  }


  add = (m,n) =>{
    return m+parseInt(n);
    // let addVal = 0;
    // for (let v of numberArray) {
    //   addVal = addVal + parseInt(v);
    // }
    // return parseInt(numberArray[0])+parseInt(numberArray[1]);
  }

  sub = (m,n) =>{
    return m-parseInt(n);
    // return parseInt(numberArray[0])-parseInt(numberArray[1]);
  }

  mul = (m,n) =>{
    return m*parseInt(n);
    // return parseInt(numberArray[0]) * parseInt(numberArray[1]);
  }

  div = (m,n) =>{
    return m/parseInt(n);
    // return parseInt(numberArray[0]) / parseInt(numberArray[1]);
  }

  rem = (m,n) =>{
    return m%parseInt(n);
    // return parseInt(numberArray[0]) % parseInt(numberArray[1]);
  }

  render(){

    // const styleInline = {
    //   backgroundcolor:'white',
    //   font:'inherit',
    //   border: '1x solid blue',
    //   padding: '8px',
    //   cursor:'pointer'
    // };

     return (
       <div className="App" >

          <div className="display-section">
              <div id="calculationArea" className="calculation-area"></div>
              <div id="resultArea" className="result-area"></div>
          </div>
          <div className="button-section">
              <div className="button-row">
                <Button name="C" changeRef={this.clearDisplaySection} />
                <Button name="+/-" changeRef={this.getValueHandler}/>
                <Button name="%" changeRef={this.getValueHandler}/>
                <Button name="/" mathVal="true" changeRef={this.getValueHandler}/>
              </div>
              <div className="button-row">
                <Button name="7" changeRef={this.getValueHandler}/>
                  <Button name="8" changeRef={this.getValueHandler}/>
                  <Button name="9" changeRef={this.getValueHandler}/>
                  <Button name="*" mathVal="true" changeRef={this.getValueHandler}/>
              </div>
              <div className="button-row">
                  <Button name="4" changeRef={this.getValueHandler}/>
                  <Button name="5" changeRef={this.getValueHandler}/>
                  <Button name="6" changeRef={this.getValueHandler}/>
                  <Button name="-" mathVal="true" changeRef={this.getValueHandler}/>
              </div>
              <div className="button-row">
                  <Button name="1" changeRef={this.getValueHandler}/>
                  <Button name="2" changeRef={this.getValueHandler}/>
                  <Button name="3" changeRef={this.getValueHandler}/>
                  <Button name="+" mathVal="true" changeRef={this.getValueHandler}/>
              </div>
              <div className="button-row">
                  <Button name="0" changeRef={this.getValueHandler}/>
                  <Button name="." changeRef={this.getValueHandler}/>
                  <Button name="=" changeRef={this.calculation}/>
              </div>
              {/* <Button name="5"/> */}
          </div>
       </div>
        // <div className="App">
        //     <h1>Hi, I am a React App</h1>
        //     <p>This is really working!</p>
        //     <button style={styleInline} id="btn" onClick={this.switchNameHandler.bind(this,'Roy')}>Switch Name</button>
        //     {/* <button id="btn" onClick={this.switchNameHandler.bind(this,'Roy')}>Switch Name</button> You can pass
        //      parameter in a function using bind
        //     <button id="btn" onClick={() => this.switchNameHandler('Roy')}>Switch Name</button> 
        //         or You can pass parameter in a function using anonymous function but try to use bind if possible
        //     */}
        //     {/* <Person name="Anish" age="26"/>
        //     <Person name="Max" age="27">My Hobbies:Racing</Person>
        //     <Person  name="Vikash" age="29"/> */}

        //     <Person name={this.state.persons[0].name} age={this.state.persons[0].age} />
        //     <Person 
        //       name={this.state.persons[1].name} 
        //       age={this.state.persons[1].age} 
        //       clickRef={this.switchNameHandler.bind(this,'Max!')} //By using this we can pass any method reference to any component
        //       changeRef={this.nameChangeHandler}
        //     >My Hobbies:Racing
        //     </Person>
        //     <Person  name={this.state.persons[2].name} age={this.state.persons[2].age} />
        // </div>
     );

    // below code will work like above jsx
    // return React.createElement('div',{className:'App'},React.createElement('h1',null,'Hi I\'m a React App!!!.'));
  }
}

export default App;

// Functional Component or Function based Component
// React Hooks Syntax

// const App = props =>{

//   const [personState,setPersonState] = useState({
//     persons : [
//       {name : "Anish" , age: 26},
//       {name : "Max" , age: 27},
//       {name : "Vikash" , age: 39}
//     ]

//   });

//   const [otherState,setOtherState] = useState('Some other values');
//   console.log(otherState,setOtherState);
//   const switchNameHandler = () => {
//     //console.log("Was Clicked");
//     // this.state.persons[0].name="MaxiMilian";
//     setPersonState({
//       persons : [
//         {name : "Anish Sharma" , age: 26},
//         {name : "Max" , age: 27},
//         {name : "Vikash" , age: 29}
//       ]
//     })
//   }

//   return (
//             <div className="App">
//                 <h1>Hi, I am a React App</h1>
//                 <p>This is really working!</p>
//                 <button id="btn" onClick={switchNameHandler}>Switch Name</button>
//                 {/* <Person name="Anish" age="26"/>
//                 <Person name="Max" age="27">My Hobbies:Racing</Person>
//                 <Person  name="Vikash" age="29"/> */}
    
//                 <Person name={personState.persons[0].name} age={personState.persons[0].age} />
//                 <Person name={personState.persons[1].name} age={personState.persons[1].age} >My Hobbies:Racing</Person>
//                 <Person  name={personState.persons[2].name} age={personState.persons[2].age} />
//             </div>
//          );
// }

// export default App;
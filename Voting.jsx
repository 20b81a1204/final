import React, { Component } from "react";
import UserService from "../services/UserService";
import Logout from './Logout';
import Login from "./Login";
import {  useNavigate } from "react-router-dom";

class Voting extends Component{
    constructor(props)
    {
        super(props)
        this.state={
            votes:[],
            voted:false
            
        }
        
        this.editVotes=this.editVotes.bind(this);
    }
     
    editVotes(cid){
        UserService.addVote(cid).then((res)=>
        {
            console.log("you have voted");
           // this.setState({voted:true})
           //this.props.navigate('./Logout.jsx');
            
        });
    }
    
    componentDidMount(){
        UserService.getUsers().then((res)=>
        {
            this.setState({votes:res.data})
            
        })
    }
    

    render(){
        return(
            <div>
                <h2 className="text-center">Vote Here</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Candidate name</th>
                                <th>Candidate party</th>
                                <th>Actions</th>
                                

                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.votes.map(
                                    votes =>
                                    <tr key={votes.cid}>
                                        <td>{votes.name}</td>
                                        <td>{votes.party}</td>
                                        <td>
                                            <button onClick={()=>this.editVotes(votes.cid)} className="btn btn-info">Vote</button>
                                        </td>
                                    </tr>
                                    
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
        
    
}

export default Voting;

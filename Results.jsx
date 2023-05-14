import React, { Component } from "react";
import UserService from "../services/UserService";

class Results extends Component{
    constructor(props)
    {
        super(props)
        this.state={
            votes:[]
        }
    }
    componentDidMount(){
        UserService.getResult().then((res)=>
        {
            this.setState({votes:res.data})
        })
    }

    render(){
        return(
            <div>
                <h2 className="text-center">Results</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Candidate name</th>
                                <th>Candidate party </th>
                                <th>Candidate votes</th>
                                

                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.votes.map(
                                    votes =>
                                    <tr key={votes.cid}>
                                        
                                        <td>{votes.name}</td>
                                        <td>{votes.party}</td>
                                        <td>{votes.vote}</td>
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

export default Results;

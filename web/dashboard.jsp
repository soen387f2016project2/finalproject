<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="centered-content">
                <h1 id="dashboard">Dashboard</h1>
                        
                <h2>Overdue Resources</h2>
                
                <table class="table table-hover" id="report-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>Reserved by</th>
                            <th>From</th>
                            <th>Until</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="danger">
                            <td><a href="update-resource.jsp">DTPC0104</a></td>
                            <td><a href="update-resource.jsp">Computer</a></td>
                            <td><a href="update-resource.jsp">Dell OptiPlex 7040 desktop PC (Intel Core i7-6700, 8GB RAM, 500GB HDD)</a></td>
                            <td><a href="update-resource.jsp">Sebastien Charbonneau</a></td>
                            <td><a href="update-resource.jsp">October 2nd, 2016</a></td>
                            <td><a href="update-resource.jsp">October 9th, 2016</a></td>
                        </tr>
                        <tr class="danger">
                            <td>MNTR0089</td>
                            <td>Montior</td>
                            <td>Dell U2417H (24 inch IPS monitor, 1920 x 1200)</td>
                            <td>Sebastien Charbonneau</td>
                            <td>October 2nd, 2016</td>
                            <td>October 9th, 2016</td>
                        </tr>
                    </tbody>    
                </table>
                
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->
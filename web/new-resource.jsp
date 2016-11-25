<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1 id="new-resource-title">New Resource</h1>
                <a href="#computer">Computer</a> | <a href="#projector">Projector</a> | <a href="#room">Conference room</a> | <a href="#misc">Miscellaneous</a>
                
                <hr>
                <h2 id="computer">Computer</h2>
                <form action="inventory-report.jsp">
                    <div class="form-group row">
                        <label for="computerId" class="col-lg-2">ID number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="computerId">
                        </div>
                    </div>                    
                    <fieldset class="form-group row">
                        <label class="col-lg-2">Computer type</label>
                        <div class="col-sm-10">
                            <div class="radio">
                                <label><input type="radio" name="computerType" id="computerType1" value="Desktop" checked>Desktop</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="computerType" id="computerType2" value="Laptop">Laptop</label>
                            </div>
                        </div>
                    </fieldset>
                    <div class="form-group row">
                        <label for="computerModel" class="col-lg-2">Make and model</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="computerModel" placeholder="e.g. Lenovo ThinkPad Yoga 900">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="computerSize" class="col-lg-2">Screen size (inches)</label>
                        <div class="col-lg-4">
                            <input type="number" class="form-control" id="computerSize" placeholder="e.g. 13">
                        </div>
                    </div>
                    <div class="form-group row">    
                        <label for="computerCPU" class="col-lg-2">CPU</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="computerCPU" placeholder="e.g. Intel Core i7-6700">
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="computerRAM" class="col-lg-2">RAM memory</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="computerRAM" placeholder="e.g. 8GB DDR4 2133MHz">
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="computerStorage" class="col-lg-2">Storage capacity</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="computerStorage" placeholder="e.g. 128GB">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-6">
                            <button type="submit" class="btn btn-primary">Add Computer</button>
                        </div>
                    </div>
                    <div class="form-messages">
                        <div class="alert alert-danger" role="alert">Duplicate ID number.</div>
                    </div>
                </form>
                <hr>        
                
                <h2 id="projector">Projector</h2>
                <form action="inventory-report.jsp">
                    <div class="form-group row">
                       <label for="projectorId" class="col-lg-2">ID number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="projectorId">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="projectorModel" class="col-lg-2">Make and model</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="projectorModel" placeholder="e.g. Epson EX9200 Pro">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="projectorResolution" class="col-lg-2">Maximum resolution</label>
                        <div class="col-lg-4">
                            <input type="number" class="form-control" id="computerSize" placeholder="e.g. 1920 x 1200">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary">Add Projector</button>
                        </div>
                    </div>
                </form>
                <hr>
                
                <h2 id="room">Conference room</h2>
                <form action="inventory-report.jsp">
                    <div class="form-group row">
                       <label for="roomId" class="col-lg-2">ID number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="roomId">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="roomCapacity" class="col-lg-2">Maximum capacity</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="roomCapacity" placeholder="e.g. 12">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="whiteboard" class="col-lg-2">Has a whiteboard?</label>
                        <div class="col-lg-4">
                            <select class="form-control" id="whiteboard">
                                <option value="hasWhiteboard" selected>Yes</option>
                                <option value="noWhiteboard">No</option>
                            </select>    
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="telephone" class="col-lg-2">Has a telephone?</label>
                        <div class="col-lg-4">
                            <select class="form-control" id="telephone">
                                <option value="hasTelephone" selected>Yes</option>
                                <option value="noTelephone">No</option>
                            </select>    
                        </div>
                    </div> 
                     <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary">Add Conference Room</button>
                        </div>
                    </div>
                </form>
                <hr>
                
                <h2 id="misc">Miscellaneous</h2>
                <form action="inventory-report.jsp">
                    <div class="form-group row">
                       <label for="miscellaneous" class="col-lg-2">ID number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="miscellaneous">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="description" class="col-lg-2">Description</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="description" placeholder="e.g. Plantronics bluetooth headset">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary">Add Resource</button>
                        </div>
                    </div>
                </form>
                
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->

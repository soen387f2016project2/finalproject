<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

<script type="text/javascript">
    function show(form) {
        if (form == 1) {
            document.getElementById("compForm").style.visibility = "visible";
            document.getElementById("compForm").style.display = "inline";
            document.getElementById("projForm").style.visibility = "hidden";
            document.getElementById("projForm").style.display = "none";
            document.getElementById("confForm").style.visibility = "hidden";
            document.getElementById("confForm").style.display = "none";
            document.getElementById("miscForm").style.visibility = "hidden";
            document.getElementById("miscForm").style.display = "none";
        } else if (form == 2) {
            document.getElementById("compForm").style.visibility = "hidden";
            document.getElementById("compForm").style.display = "none";
            document.getElementById("projForm").style.visibility = "visible";
            document.getElementById("projForm").style.display = "inline";
            document.getElementById("confForm").style.visibility = "hidden";
            document.getElementById("confForm").style.display = "none";
            document.getElementById("miscForm").style.visibility = "hidden";
            document.getElementById("miscForm").style.display = "none";
        } else if (form == 3) {
            document.getElementById("compForm").style.visibility = "hidden";
            document.getElementById("compForm").style.display = "none";
            document.getElementById("projForm").style.visibility = "hidden";
            document.getElementById("projForm").style.display = "none";
            document.getElementById("confForm").style.visibility = "visible";
            document.getElementById("confForm").style.display = "inline";
            document.getElementById("miscForm").style.visibility = "hidden";
            document.getElementById("miscForm").style.display = "none";
        } else if (form == 4) {
            document.getElementById("compForm").style.visibility = "hidden";
            document.getElementById("compForm").style.display = "none";
            document.getElementById("projForm").style.visibility = "hidden";
            document.getElementById("projForm").style.display = "none";
            document.getElementById("confForm").style.visibility = "hidden";
            document.getElementById("confForm").style.display = "none";
            document.getElementById("miscForm").style.visibility = "visible";
            document.getElementById("miscForm").style.display = "inline";
        }
    }
</script>

<div class="container">
    <div class="leftaligned-content">
        <h1 id="new-resource-title">New Resource</h1>
        <a href="#computer" onclick="show(1)">Computer</a> | <a href="#projector" onclick="show(2)">Projector</a> | <a href="#room" onclick="show(3)">Conference room</a> | <a href="#misc" onclick="show(4)">Miscellaneous</a>

        <hr>
        <h2 id="computer">Computer</h2>
        <form id="compForm" action="CreateResource" method="post">   
            <div class="form-group row">
                <label for="computerName" class="col-lg-2">Name</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="computerName" placeholder="e.g. Sam's computer">
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
                    <input type="text" class="form-control" name="computerModel" placeholder="e.g. Lenovo ThinkPad Yoga 900">
                </div>
            </div> 
            <div class="form-group row">
                <label for="computerSize" class="col-lg-2">Screen size (inches)</label>
                <div class="col-lg-4">
                    <input type="number" class="form-control" name="computerSize" placeholder="e.g. 13">
                </div>
            </div>
            <div class="form-group row">    
                <label for="computerCPU" class="col-lg-2">CPU</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="computerCPU" placeholder="e.g. Intel Core i7-6700">
                </div>
            </div> 
            <div class="form-group row">    
                <label for="computerRAM" class="col-lg-2">RAM memory</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="computerRAM" placeholder="e.g. 8GB DDR4 2133MHz">
                </div>
            </div> 
            <div class="form-group row">    
                <label for="computerStorage" class="col-lg-2">Storage capacity</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="computerStorage" placeholder="e.g. 128GB">
                </div>
            </div> 
            <input type="hidden" name="resourceType" value="computer" />
            <div class="form-group row">
                <div class="col-lg-6">
                    <button type="submit" class="btn btn-primary">Add Computer</button>
                </div>
            </div>            
        </form>
        <hr>        

        <h2 id="projector">Projector</h2>
        <form id="projForm" action="CreateResource" method="post">  
            <div class="form-group row">
                <label for="projectorName" class="col-lg-2">Name</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="projectorName" placeholder="e.g. Sam's projector">
                </div>
            </div>                    
            <div class="form-group row">
                <label for="projectorModel" class="col-lg-2">Make and model</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="projectorModel" placeholder="e.g. Epson EX9200 Pro">
                </div>
            </div> 
            <div class="form-group row">
                <label for="projectorResolution" class="col-lg-2">Maximum resolution</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="projectorRes" placeholder="e.g. 1920 x 1200">
                </div>
            </div>
            <input type="hidden" name="resourceType" value="projector" />
            <div class="form-group row">
                <div class="col-lg-2">
                    <button type="submit" class="btn btn-primary">Add Projector</button>
                </div>
            </div>
        </form>
        <hr>

        <h2 id="room">Conference room</h2>
        <form id="confForm" action="CreateResource" method="post">      
            <div class="form-group row">
                <label for="roomName" class="col-lg-2">Name</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="roomName" placeholder="e.g. Sam's conference room">
                </div>
            </div>
            <div class="form-group row">
                <label for="roomLocation" class="col-lg-2">Location</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="roomLocation" placeholder="e.g. West wing">
                </div>
            </div>
            <div class="form-group row">
                <label for="roomCapacity" class="col-lg-2">Maximum capacity</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="roomCapacity" placeholder="e.g. 12">
                </div>
            </div> 
            <div class="form-group row">
                <label for="whiteboard" class="col-lg-2">Has a whiteboard?</label>
                <div class="col-lg-4">
                    <select class="form-control" name="whiteboard">
                        <option value="hasWhiteboard" selected>Yes</option>
                        <option value="noWhiteboard">No</option>
                    </select>    
                </div>
            </div> 
            <div class="form-group row">
                <label for="telephone" class="col-lg-2">Has a telephone?</label>
                <div class="col-lg-4">
                    <select class="form-control" name="telephone">
                        <option value="hasTelephone" selected>Yes</option>
                        <option value="noTelephone">No</option>
                    </select>    
                </div>
            </div> 
            <input type="hidden" name="resourceType" value="conferenceRoom" />
            <div class="form-group row">
                <div class="col-lg-2">
                    <button type="submit" class="btn btn-primary">Add Conference Room</button>
                </div>
            </div>
        </form>
        <hr>

        <h2 id="misc">Miscellaneous</h2>
        <form id="miscForm" action="CreateResource" method="post"> 
            <div class="form-group row">
                <label for="miscName" class="col-lg-2">Name</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="miscName" placeholder="e.g. Sam's miscellaneous resource">
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-lg-2">Description</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" name="description" placeholder="e.g. Plantronics bluetooth headset">
                </div>
            </div>
            <input type="hidden" name="resourceType" value="misc" />
            <div class="form-group row">
                <div class="col-lg-2">
                    <button type="submit" class="btn btn-primary">Add Resource</button>
                </div>
            </div>
        </form>

    </div>
</div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->

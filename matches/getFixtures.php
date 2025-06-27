<?php
	$data = array();

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="battles";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "SELECT t1.name as home, t1.emblem as h_emblem, t2.name as away, t2.emblem as a_emblem from (fixtures join team as t1 on home=t1.id) join team t2 on away=t2.id;";
	$result = mysqli_query($dbh, $sql);
	while ($row = mysqli_fetch_array($result)) { 
	    
	    $key = $row['home']."-".$row['away'];
	    $nested_data = array();
	    $nested_data['h_emblem'] = $row['h_emblem'];
   	    $nested_data['a_emblem'] = $row['a_emblem'];
		$data[$key] = $key;
	}

	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
?>

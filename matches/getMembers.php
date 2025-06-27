<?php

	$data = array();

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="battles";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "SELECT team.name as name, team.emblem as emblem, GROUP_CONCAT(team_member.name) AS player, GROUP_CONCAT(team_member.image) AS images FROM team JOIN team_member on team.id = team_member.team GROUP BY team.name;";
	$result = mysqli_query($dbh, $sql);
	while ($row = mysqli_fetch_array($result)) {
        $nested_data = array();
        $nested_data['emblem']=$row['emblem'];        
        $nested_data['players']=$row['player'];
        $nested_data['images']=$row['images'];
		$data[$row['name']] = $nested_data;
	}

	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
?>

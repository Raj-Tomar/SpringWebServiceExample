SHOW STATUS WHERE `variable_name` = 'Threads_connected';

SET GLOBAL max_connections = 500;

SHOW VARIABLES LIKE "max_connections";

SHOW VARIABLES LIKE '%buffer%';

SHOW PROCESSLIST;
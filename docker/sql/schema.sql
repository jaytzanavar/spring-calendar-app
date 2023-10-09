CREATE TABLE IF NOT EXISTS Run (
    run_id INT NOT NULL,
    title varchar(250) NOT NULL,
    miles INT NOT NULL,
    PRIMARY KEY (run_id)
);

INSERT INTO Run(run_id, title, miles) VALUES (1,'Monday Morning Run',3);
INSERT INTO Run(run_id, title, miles) VALUES (1,'Wednesday Afternoon Run',3);
INSERT INTO Run(run_id, title, miles) VALUES (1,'Saturday Morning Run',3);
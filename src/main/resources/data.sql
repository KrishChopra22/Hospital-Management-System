INSERT into patient (name, gender, birth_date, email, blood_group, created_at)
VALUES
    ('Ajay Patel', 'MALE', '1987-04-21', 'ajay.patel@example.com', 'B_POSITIVE', NOW()),
    ('Ranu Mandal', 'FEMALE', '1996-07-11', 'ranu.mandal@example.com', 'O_POSITIVE', NOW()),
    ('Nisha Verma', 'FEMALE', '1989-12-07', 'nisha.verma@example.com', 'AB_NEGATIVE', NOW()),
    ('Raghav Singh', 'MALE', '1978-08-24', 'raghav.singh@example.com', 'A_NEGATIVE', NOW());

INSERT into doctor (name, gender, specialization, email)
VALUES
    ('Dr. Vikas Mehto', 'MALE', 'Cardiology', 'vikas.mehto@example.com'),
    ('Dr. Sumit Biswas', 'MALE', 'Orthopedics', 'sumit.biswas@example.com'),
    ('Dr. Sneha Sharma', 'FEMALE', 'Dermatology', 'sneha.sharma@example.com');

INSERT into appointment (appointment_time, reason, doctor_id, patient_id, created_at)
VALUES
    ('2025-07-24 09:15:00', 'General Checkup', 2, 1, NOW()),
    ('2025-07-24 10:30:00', 'Skin allergy', 3, 3, NOW()),
    ('2025-07-30 08:30:00', 'Chest Pain', 1, 4, NOW()),
    ('2025-08-01 10:00:00', 'Knee Surgery', 2, 2, NOW()),
    ('2025-08-04 09:00:00', 'Follow-up Visit', 1, 4, NOW()),
    ('2025-08-12 13:45:00', 'Heart Surgery', 1, 3, NOW());
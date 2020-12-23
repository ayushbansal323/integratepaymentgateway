import csv
import os

from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker

engine = create_engine("postgres://ungkulfisrnybh:3d10836edf677c384941df2442ec22794a6a47d982b8ec363843aef626337983@ec2-54-247-107-109.eu-west-1.compute.amazonaws.com:5432/d8hseb5linsmun")
db = scoped_session(sessionmaker(bind=engine))

def main():
    db.execute(""" CREATE TABLE IF NOT EXISTS customer ( customer_id VARCHAR(300) NOT NULL , email VARCHAR(50) PRIMARY KEY)""")
    
    db.commit()

if __name__ == "__main__":
    main()

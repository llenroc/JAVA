%python
import pandas as pd
import json
import unittest

#1.Creating unit tests to check montly counts for 2017 year:
def test_countRows201701():
    file_json="/mnt/staging5/equarthquake_2017_01.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=11263        
    assert int(inputCount) == expectedOutput

def test_countRows201702():
    file_json="/mnt/staging5/equarthquake_2017_02.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=8058        
    assert int(inputCount) == expectedOutput
    
def test_countRows201703():
    file_json="/mnt/staging5/equarthquake_2017_03.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=9174        
    assert int(inputCount) == expectedOutput
    
def test_countRows201704():
    file_json="/mnt/staging5/equarthquake_2017_04.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=10807        
    assert int(inputCount) == expectedOutput
    
def test_countRows201705():
    file_json="/mnt/staging5/equarthquake_2017_05.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=13642        
    assert int(inputCount) == expectedOutput
    
def test_countRows201706():
    file_json="/mnt/staging5/equarthquake_2017_06.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=11387        
    assert int(inputCount) == expectedOutput        
    
def test_countRows201707():
    file_json="/mnt/staging5/equarthquake_2017_07.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=13077        
    assert int(inputCount) == expectedOutput
    
def test_countRows201708():
    file_json="/mnt/staging5/equarthquake_2017_08.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=12305        
    assert int(inputCount) == expectedOutput
    
def test_countRows201709():
    file_json="/mnt/staging5/equarthquake_2017_09.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=11560        
    assert int(inputCount) == expectedOutput
    
def test_countRows201710():
    file_json="/mnt/staging5/equarthquake_2017_10.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=9873        
    assert int(inputCount) == expectedOutput
    
def test_countRows201711():
    file_json="/mnt/staging5/equarthquake_2017_11.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=9873        
    assert int(inputCount) == expectedOutput    
    
def test_countRows201712():
    file_json="/mnt/staging5/equarthquake_2017_12.json"
    dfInput = sqlContext.read.load(file_json, format="json")
    inputCount = dfInput.count()    
    expectedOutput=9604        
    assert int(inputCount) == expectedOutput       

#2.running unit tests:   
if __name__ == "__main__":
    test_countRows201701()
    test_countRows201702()
    test_countRows201703()
    test_countRows201704()
    test_countRows201705()
    test_countRows201706()
    test_countRows201707()
    test_countRows201708()
    test_countRows201709()
    test_countRows201710()
    test_countRows201711()
    test_countRows201712()
    
    print("count(*) checks passed for 2017 year")         